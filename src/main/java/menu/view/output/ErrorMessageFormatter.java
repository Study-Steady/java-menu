package menu.view.output;


import menu.view.CharacterSymbol;

public class ErrorMessageFormatter {

    private static final String ERROR_PREFIX = "[ERROR]";

    private ErrorMessageFormatter() {
    }

    public static String addErrorPrefix(String message) {
        return ERROR_PREFIX + CharacterSymbol.BLANK.getLiteral() + message;
    }

}
