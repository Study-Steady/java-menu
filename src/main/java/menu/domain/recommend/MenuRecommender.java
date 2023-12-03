package menu.domain.recommend;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.recommend.category.MenuCategoryPicker;
import menu.domain.recommend.menu.MenuPicker;

public class MenuRecommender {

    private static final List<DayOfWeek> lunchDays = List.of(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY
    );

    private final MenuCategoryPicker categoryPicker;
    private final MenuPicker menuPicker;

    private final Coaches coaches;

    public MenuRecommender(MenuCategoryPicker categoryPicker, MenuPicker menuPicker, Coaches coaches) {
        this.categoryPicker = categoryPicker;
        this.menuPicker = menuPicker;
        this.coaches = coaches;
    }

    public MenuRecommendResult recommend() {
        List<MenuCategory> pickedMenuCategories = new ArrayList<>();

        for (DayOfWeek lunchDay : lunchDays) {
            MenuCategory pickedCategory = pickCategory(pickedMenuCategories);
            pickedMenuCategories.add(pickedCategory);

            for (Coach coach : coaches.getCoaches()) {
                Menu pickedMenu = this.menuPicker.pick(coach, pickedCategory, coach.getRecommended());
                coach.recommendedMenu(pickedMenu);
            }
        }

        return new MenuRecommendResult(pickedMenuCategories, this.coaches);
    }

    private MenuCategory pickCategory(List<MenuCategory> pickedMenuCategories) {
        return this.categoryPicker.pick(pickedMenuCategories);
    }

}
