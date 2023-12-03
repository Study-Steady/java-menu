package menu.utils;

import java.util.Arrays;
import java.util.List;
import menu.view.CharacterSymbol;

public class StringConvertor {

    private StringConvertor() {
    }

    public static String removeBlank(String source) {
        return source.replaceAll(CharacterSymbol.BLANK.getLiteral(), "");
    }

    public static List<String> splitByComma(String source) {
        return Arrays.asList(source.split(CharacterSymbol.COMMA.getLiteral()));
    }

}
