package menu.view.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menu.util.StringConvertor;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateCoacheName(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if(coache.length() < 2 || coache.length() > 4) {
                        throw new IllegalArgumentException("코치 이름은 2글자 이상 4글자 이하이어야 합니다");
                    }
                });
    }

    public static void validateCoacheNameType(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if (!RegexPattern.KOREAN_OR_ENGLISH.matches(coache)) {
                        throw new IllegalArgumentException("코치 이름은 한글 또는 영어만 입력할 수 있습니다.");
                    }
                });
    }

    public static void validateCoachesCount(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if (coaches.length < 2 || coaches.length > 5) {
                        throw new IllegalArgumentException("코치의 수는 최소 2명 최대 5명이어야 합니다.");
                    }
                });
    }

    public static void validateDuplicate(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        Set<String> duplicationNames = getDuplicationStrings(coaches);
        if (coaches.length != duplicationNames.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private static Set<String> getDuplicationStrings(String[] strings) {
        return new HashSet<>(Arrays.asList(strings));
    }

    public static void validateSeparator(String input) {
        if (!input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("코치들은 쉼표(,)로 구분하여 입력해야 합니다.");
        }
    }
}
