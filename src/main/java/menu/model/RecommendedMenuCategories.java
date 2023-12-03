package menu.model;

import java.util.List;

public class RecommendedMenuCategories {
    private final List<MenuCategory> menuCategories;

    public RecommendedMenuCategories(List<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public static RecommendedMenuCategories from(List<MenuCategory> recommendedMenuCategory) {
        return new RecommendedMenuCategories(recommendedMenuCategory);
    }

    public void recommendMenus(Coaches coaches, Picker picker) {
        for (MenuCategory menuCategory : menuCategories) {
            menuCategory.recommendMenusTo(coaches, picker);
        }
    }
}
