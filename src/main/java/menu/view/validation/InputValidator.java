package menu.view.validation;

import java.util.Arrays;
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

    public static void validateCoachesCount(String input) {
        String[] coaches = StringConvertor.splitByComma(input);
        Arrays.stream(coaches)
                .forEach(coache -> {
                    if (coaches.length < 2 || coaches.length > 5) {
                        throw new IllegalArgumentException("코치의 수는 최소 2명 최대 5명이어야 합니다.");
                    }
                });
    }
}
