package menu.model;

public class CoachName {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;

    public CoachName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("코치 이름은 최소 %d글자, 최대 %d글자까지 가능합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public static CoachName from(String name) {
        return new CoachName(name);
    }

    public String getName() {
        return name;
    }
}
