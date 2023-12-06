package menu.view.validation;

import menu.domain.Menu;
import menu.util.StringConvertor;

public class InedibleMenuValidator {
    private static final int MAX_MENU_COUNT = 2;

    private InedibleMenuValidator() {
    }

    public static void validate(String input) {
        validateSeparator(input);
        String[] names = StringConvertor.splitByComma(input);
        validateMenuName(names);
        validateMenuCount(names);
    }

    private static void validateSeparator(String input) {
        String[] splitMenuNames = StringConvertor.splitByComma(input);
        if (splitMenuNames.length > 1 && !input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }

    private static void validateMenuName(String[] menus) {
        for (String menu : menus) {
            if (!menu.isEmpty() && !Menu.containsMenu(menu)) {
                throw new IllegalArgumentException("메뉴판에 없는 메뉴 입니다.");
            }
        }
    }

    private static void validateMenuCount(String[] menus) {
        if (menus.length > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개 까지 입력 가능합니다.");
        }
    }
}
