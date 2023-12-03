package menu.view.validator;

import java.util.regex.Pattern;

public class CoachNamesValidator {
    private static final Pattern ENGLISH_OR_KOREAN_WITH_COMMA_SEPARATED = Pattern.compile(
            "[A-Za-z가-힣]+(,[A-Za-z가-힣]+)*");
    private static final String FORMAT_EXCEPTION_MESSAGE = "영어, 한글 및 ',' 형식만 입력 가능합니다.";

    private CoachNamesValidator() {
    }

    public static void validate(String input) {
        if (!matchesPattern(input, ENGLISH_OR_KOREAN_WITH_COMMA_SEPARATED)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}
