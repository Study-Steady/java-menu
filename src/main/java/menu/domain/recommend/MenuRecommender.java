package menu.domain.recommend;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<MenuRecommendResult> recommend() {
        return this.coaches.getCoaches()
                .stream()
                .map(this::recommend)
                .collect(Collectors.toList());
    }

    private MenuRecommendResult recommend(Coach coach) {
        List<Menu> recommendMenu = new ArrayList<>();
        List<MenuCategory> pickedMenuCategories = new ArrayList<>();

        for (DayOfWeek lunchDay : lunchDays) {
            // 카테고리 추천
            MenuCategory pickedCategory = pickCategory(pickedMenuCategories);
            pickedMenuCategories.add(pickedCategory);

            // 메뉴 추천
            Menu pickedMenu = this.menuPicker.pick(coach, pickedCategory, recommendMenu);
            recommendMenu.add(pickedMenu);
        }

        return new MenuRecommendResult(coach, recommendMenu);
    }

    private MenuCategory pickCategory(List<MenuCategory> pickedMenuCategories) {
        return this.categoryPicker.pick(pickedMenuCategories);
    }

}
