package menu.view.validation;

import menu.domain.Menu;
import menu.util.StringConvertor;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateNameSeparator(String input) {
        if (!input.isEmpty() && !input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }

    public static void validateMenuSeparator(String input) {
        String[] splitedMenuNames = StringConvertor.splitByComma(input);
        if (splitedMenuNames.length > 1) {
            if (!input.contains(StringConvertor.COMMA)) {
                throw new IllegalArgumentException("쉼표(,)로 구분하여 입력해야 합니다.");
            }
        }
    }
}
