package menu.view.validation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import menu.util.StringConvertor;

public class CoachNameValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_COACHES_COUNT = 2;
    private static final int MAX_COACHES_COUNT = 5;

    private CoachNameValidator() {
    }

    public static void validate(String input) {
        validateSeparator(input);
        String[] coaches = StringConvertor.splitByComma(input);
        validateCoachName(coaches);
        validateCoachNameType(coaches);
        validateCoachCount(coaches);
        validateDuplicate(coaches);
    }

    private static void validateSeparator(String input) {
        if (!input.isEmpty() && !input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }

    private static void validateCoachName(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coach -> {
                    if(coach.length() < MIN_NAME_LENGTH || coach.length() > MAX_NAME_LENGTH) {
                        throw new IllegalArgumentException("코치 이름은 2글자 이상 4글자 이하이어야 합니다");
                    }
                });
    }

    private static void validateCoachNameType(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coach -> {
                    if (!RegexPattern.KOREAN_OR_ENGLISH.matches(coach)) {
                        throw new IllegalArgumentException("코치 이름은 한글 또는 영어만 입력할 수 있습니다.");
                    }
                });
    }

    private static void validateCoachCount(String[] coaches) {
        if (coaches.length < MIN_COACHES_COUNT || coaches.length > MAX_COACHES_COUNT) {
            throw new IllegalArgumentException("코치의 수는 최소 2명 최대 5명이어야 합니다.");
        }
    }

    private static void validateDuplicate(String[] coaches) {
        Set<String> duplicationNames = getDuplicationCoaches(coaches);
        if (coaches.length != duplicationNames.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private static Set<String> getDuplicationCoaches(String[] coaches) {
        return Arrays.stream(coaches)
                .collect(Collectors.toSet());
    }
}
