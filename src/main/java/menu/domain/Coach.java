package menu.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menu.util.StringConvertor;
import menu.view.validation.RegexPattern;

public class Coach {
    private static final int MIN_COMMON_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_COACH_COUNT = 5;
    private String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        validateCoachName(coaches);
        validateCoachNameType(coaches);
        validateCoachCount(coaches);
        validateDuplicate(coaches);
        return new Coach(input);
    }

    private static void validateCoachName(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coach -> {
                    if(coach.length() < MIN_COMMON_LENGTH || coach.length() > MAX_NAME_LENGTH) {
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

    public static void validateCoachCount(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coach -> {
                    if (coach.length() < MIN_COMMON_LENGTH || coach.length() > MAX_COACH_COUNT) {
                        throw new IllegalArgumentException("코치의 수는 최소 2명 최대 5명이어야 합니다.");
                    }
                });
    }

    private static void validateDuplicate(String[] coaches) {
        Set<String> duplicationNames = getDuplicationStrings(coaches);
        if (coaches.length != duplicationNames.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private static Set<String> getDuplicationStrings(String[] strings) {
        return new HashSet<>(Arrays.asList(strings));
    }

    public String getName() {
        return name;
    }
}
