package menu.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import menu.util.StringConvertor;
import menu.view.validation.RegexPattern;

public class Coache {
    private static final int MIN_COMMON_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_COACHE_COUNT = 5;
    private String name;

    private Coache(String name) {
        this.name = name;
    }

    public static Coache from(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        validateCoacheName(coaches);
        validateCoacheNameType(coaches);
        validateCoachesCount(coaches);
        validateDuplicate(coaches);
        return new Coache(input);
    }

    private static void validateCoacheName(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if(coache.length() < MIN_COMMON_LENGTH || coache.length() > MAX_NAME_LENGTH) {
                        throw new IllegalArgumentException("코치 이름은 2글자 이상 4글자 이하이어야 합니다");
                    }
                });
    }

    private static void validateCoacheNameType(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if (!RegexPattern.KOREAN_OR_ENGLISH.matches(coache)) {
                        throw new IllegalArgumentException("코치 이름은 한글 또는 영어만 입력할 수 있습니다.");
                    }
                });
    }

    public static void validateCoachesCount(String[] coaches) {
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if (coache.length() < MIN_COMMON_LENGTH || coache.length() > MAX_COACHE_COUNT) {
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
