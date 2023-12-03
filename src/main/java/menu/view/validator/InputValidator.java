package menu.view.validator;

import menu.common.Symbol;
import menu.util.validator.GeneralValidator;
import menu.util.validator.StringValidator;

public class InputValidator {
    public static final String COACHES_SEPARATOR = Symbol.COMMA;
    public static final String AVOIDED_MENUS_SEPARATOR = Symbol.COMMA;

    private InputValidator() {
    }

    public static void validateCoaches(String coaches, String target) {
        StringValidator.validateBlank(coaches, target);
        GeneralValidator.validateDuplicateSubstring(COACHES_SEPARATOR, coaches, target);
        GeneralValidator.validateStartSubstring(COACHES_SEPARATOR, coaches, target);
        GeneralValidator.validateEndSubstring(COACHES_SEPARATOR, coaches, target);
    }

    public static void validateAvoidedMenu(String avoidedMenu, String target) {
        GeneralValidator.validateDuplicateSubstring(AVOIDED_MENUS_SEPARATOR, avoidedMenu, target);
        GeneralValidator.validateStartSubstring(AVOIDED_MENUS_SEPARATOR, avoidedMenu, target);
        GeneralValidator.validateEndSubstring(AVOIDED_MENUS_SEPARATOR, avoidedMenu, target);
    }
}
