package menu.view.validation;

import java.util.regex.Pattern;

public enum RegexPattern {
    KOREAN_OR_ENGLISH(Pattern.compile("[a-zA-Z가-힣]*"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
