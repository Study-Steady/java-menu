package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;

public class MenuUtils {
    private MenuUtils() {
    }

    public static MenuCategory getRandomMenuCategory() {
        return MenuCategory.fromNum(Randoms.pickNumberInRange(1, 5));
    }

    public static Menu getRandomMenu(MenuCategory menuCategory) {
        return Menu.getMenusByMenuCategory(menuCategory).get(0);
    }
}
