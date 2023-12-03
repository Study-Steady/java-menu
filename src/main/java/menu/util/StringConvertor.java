package menu.util;

public class StringConvertor {
    public static final String COMMA = ",";

    private StringConvertor() {
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }

    public static String convertTrimedString(String input) {
        String[] coaches = input.split(COMMA);
        for (int i = 0; i < coaches.length; i++) {
            coaches[i] = coaches[i].trim();
        }
        return String.join(COMMA, coaches);
    }
}
