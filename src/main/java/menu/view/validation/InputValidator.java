package menu.view.validation;

import menu.util.StringConvertor;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateSeparator(String input) {
        if (!input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("코치들은 쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }
}
