package menu.model;

public class CoachName {
    private final String name;

    public CoachName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치 이름은 2자 이상 4자 이하만 가능합니다.");
        }
    }

    public static CoachName from(String name) {
        return new CoachName(name);
    }
}
