package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.util.StringConvertor;

public class InedibleMenus {
    private static final int MAX_MENU_COUNT = 2;
    private final List<String> menus;

    private InedibleMenus(List<String> menus) {
        this.menus = menus;
    }

    public static InedibleMenus from(String menuNames) {
        validateMenuName(menuNames);
        String[] names = StringConvertor.splitByComma(menuNames);
        validateMenuCount(names);
        return new InedibleMenus(Arrays.asList(names));
    }

    private static void validateMenuName(String input) {
        if (!Menu.containsMenu(input)) {
            throw new IllegalArgumentException("메뉴판에 없는 메뉴 입니다.");
        }
    }

    private static void validateMenuCount(String[] names) {
        if (names.length > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개 까지 입력 가능합니다.")
        }
    }

    @Override
    public String toString() {
        return "InedibleMenus{" +
                "menus=" + menus +
                '}';
    }
}
