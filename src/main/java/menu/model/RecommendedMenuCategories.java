package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendedMenuCategories {
    private static final int MAX_SIZE = 5;
    private static final int MAX_FREQUENCY = 2;

    private final List<MenuCategory> menuCategories;

    RecommendedMenuCategories(List<MenuCategory> menuCategories) {
        validate(menuCategories);
        this.menuCategories = new ArrayList<>(menuCategories);
    }

    private void validate(List<MenuCategory> menuCategories) {
        validateSize(menuCategories);
        validateFrequency(menuCategories);
    }

    private void validateSize(List<MenuCategory> menuCategories) {
        if (menuCategories.size() != MAX_SIZE) {
            throw new IllegalArgumentException("추천 카테고리는 5개여야 합니다.");
        }
    }

    private void validateFrequency(List<MenuCategory> menuCategories) {
        for (MenuCategory menuCategory : menuCategories) {
            if (Collections.frequency(menuCategories, menuCategory) > MAX_FREQUENCY) {
                throw new IllegalArgumentException("추천 카테고리는 같은 카테고리가 최대 2개까지만 가능합니다.");
            }
        }
    }

    public static RecommendedMenuCategories create(NumberGenerator numberGenerator) {
        List<MenuCategory> recommendedMenuCategories = new ArrayList<>();
        while (recommendedMenuCategories.size() < MAX_SIZE) {
            MenuCategory menuCategory = MenuCategory.findCategory(numberGenerator);
            if (Collections.frequency(recommendedMenuCategories, menuCategory) < MAX_FREQUENCY) {
                recommendedMenuCategories.add(menuCategory);
            }
        }

        return new RecommendedMenuCategories(recommendedMenuCategories);
    }

    public void recommendMenus(Coaches coaches, Picker picker) {
        for (MenuCategory menuCategory : menuCategories) {
            menuCategory.recommendMenusTo(coaches, picker);
        }
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }
}
