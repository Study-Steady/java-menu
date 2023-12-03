package menu.domain.recommend.category;

import java.util.List;
import menu.domain.menu.MenuCategory;

public class MenuCategoryPicker {

    private static final int MIN_MENU_CATEGORY_NO = MenuCategory.JAPANESE.getMenuNo();
    private static final int MAX_MENU_CATEGORY_NO = MenuCategory.WESTERN.getMenuNo();

    private final RandomMenuCategoryPicker randomMenuCategoryPicker;

    public MenuCategoryPicker(RandomMenuCategoryPicker randomMenuCategoryPicker) {
        this.randomMenuCategoryPicker = randomMenuCategoryPicker;
    }

    public MenuCategory pick(List<MenuCategory> pickedMenuCategories) {
        while (true) {
            MenuCategory randomPickedCategory = randomMenuCategoryPicker.pick(MIN_MENU_CATEGORY_NO, MAX_MENU_CATEGORY_NO);

            long existCount = countExistCategory(pickedMenuCategories, randomPickedCategory);

            if (existCount < 2) {
                return randomPickedCategory;
            }
        }
    }

    private long countExistCategory(List<MenuCategory> pickedMenuCategories, MenuCategory randomPickedCategory) {
        return pickedMenuCategories.stream()
                .filter(menuCategory -> menuCategory == randomPickedCategory)
                .count();
    }

}
