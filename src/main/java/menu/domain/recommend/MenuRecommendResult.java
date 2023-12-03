package menu.domain.recommend;

import java.util.List;
import menu.domain.coach.Coaches;
import menu.domain.menu.MenuCategory;

public class MenuRecommendResult {

    private final List<MenuCategory> menuCategories;
    private final Coaches coaches;

    public MenuRecommendResult(List<MenuCategory> menuCategories, Coaches coaches) {
        this.menuCategories = menuCategories;
        this.coaches = coaches;
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }

    public Coaches getCoaches() {
        return coaches;
    }

}
