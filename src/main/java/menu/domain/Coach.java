package menu.domain;

import java.util.Arrays;
import menu.util.StringConvertor;
import menu.view.validation.RegexPattern;

public class Coach {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        validateCoachName(coaches);
        validateCoachNameType(coaches);
        return new Coach(input);
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

    public String getName() {
        return name;
    }
}
