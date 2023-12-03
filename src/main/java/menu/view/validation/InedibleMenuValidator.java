package menu.view.validation;

import menu.domain.Menu;
import menu.util.StringConvertor;

public class InedibleMenuValidator {
    private static final int MAX_MENU_COUNT = 2;

    private InedibleMenuValidator() {
    }

    public static void validate(String input) {
        validateSeparator(input);
        validateMenuName(input);
        String[] names = StringConvertor.splitByComma(input);
        validateMenuCount(names);
    }


    private static void validateSeparator(String input) {
        String[] splitedMenuNames = StringConvertor.splitByComma(input);
        if (splitedMenuNames.length > 1) {
            if (!input.contains(StringConvertor.COMMA)) {
                throw new IllegalArgumentException("쉼표(,)로 구분하여 입력해야 합니다.");
            }
        }
    }

    private static void validateMenuName(String input) {
        if (!input.isEmpty() && !Menu.containsMenu(input)) {
            throw new IllegalArgumentException("메뉴판에 없는 메뉴 입니다.");
        }
    }

    private static void validateMenuCount(String[] names) {
        if (names.length > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개 까지 입력 가능합니다.");
        }
    }
}
