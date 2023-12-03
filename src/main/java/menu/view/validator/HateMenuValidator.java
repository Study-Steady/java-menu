package menu.view.validator;

import java.util.regex.Pattern;

public class HateMenuValidator {
    private static final Pattern KOREAN_WITH_COMMA_SEPARATED = Pattern.compile("[가-힣]+(,[가-힣]+)*");
    private static final String FORMAT_EXCEPTION_MESSAGE = "한글과 ',' 형식만 입력 가능합니다.";

    private HateMenuValidator() {
    }

    public static void validate(String input) {
        // TODO : 리펙토링 필요
        if (input.isBlank()) {
            return;
        }
        if (!matchesPattern(input, KOREAN_WITH_COMMA_SEPARATED)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}
