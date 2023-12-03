package menu.domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuHistory {
    private static final int MAX_MENU_CATEGORY_COUNT = 2;

    private final List<Menu> history;
    private final Map<MenuCategory, Integer> menuCategoryCount;

    private MenuHistory(List<Menu> history, Map<MenuCategory, Integer> menuCategoryCount) {
        this.history = history;
        this.menuCategoryCount = menuCategoryCount;
    }

    public static MenuHistory create() {
        Map<MenuCategory, Integer> menuCategoryCount =
                Stream.of(MenuCategory.values())
                        .collect(Collectors.toMap(
                                        menuCategory -> menuCategory,
                                        menuCategory -> 0
                                )
                        );
        return new MenuHistory(new ArrayList<>(), menuCategoryCount);
    }

    public void addMenu(Menu menu) {
        validateDuplicateMenu(menu);
        validateMenuCategoryCount(menu.getMenuCategory());
        history.add(menu);
        menuCategoryCount.put(menu.getMenuCategory(), menuCategoryCount.get(menu.getMenuCategory()) + 1);
    }

    public List<Menu> getHistory() {
        return Collections.unmodifiableList(history);
    }

    private void validateDuplicateMenu(Menu menu) {
        if (history.contains(menu)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMenuCategoryCount(MenuCategory menuCategory) {
        if (menuCategoryCount.get(menuCategory) >= MAX_MENU_CATEGORY_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
