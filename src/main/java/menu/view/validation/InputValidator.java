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
                    String trimmedCoache = coache.trim();
                    System.out.println(trimmedCoache);
                    if(trimmedCoache.length() < 2 || trimmedCoache.length() > 4) {
                        throw new IllegalArgumentException("코치 이름은 2글자 이상 4글자 이하이어야 합니다");
                    }
                });
    }
}
