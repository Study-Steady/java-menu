package menu.domain.menu;

import static menu.utils.MenuUtils.getRandomMenuCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuCategoryGroup {
    private static final int MAXIMUM_MENU_CATEGORY_GROUP_SIZE = 5;

    private final List<MenuCategory> menuCategoryGroup;

    private MenuCategoryGroup(List<MenuCategory> menuCategoryGroup) {
        this.menuCategoryGroup = menuCategoryGroup;
    }

    public static MenuCategoryGroup create() {
        return new MenuCategoryGroup(fillMenuCategory());
    }

    public List<MenuCategory> getMenuCategoryGroup() {
        return Collections.unmodifiableList(menuCategoryGroup);
    }

    public MenuCategory get(int index) {
        return menuCategoryGroup.get(index);
    }

    private static List<MenuCategory> fillMenuCategory() {
        List<MenuCategory> menuCategoryGroup = new ArrayList<>();
        while (menuCategoryGroup.size() < MAXIMUM_MENU_CATEGORY_GROUP_SIZE) {
            MenuCategory category = getRandomMenuCategory();
            if (Collections.frequency(menuCategoryGroup, category) < 2) {
                menuCategoryGroup.add(MenuCategory.KOREAN);
            }
        }
        return menuCategoryGroup;
    }
}
