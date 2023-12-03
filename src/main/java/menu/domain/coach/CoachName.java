package menu.domain.coach;

public class CoachName {
    private final String name;

    private CoachName(String name) {
        this.name = name;
    }

    public static CoachName from(String name) {
        validateCoachName(name);
        return new CoachName(name);
    }

    public String getName() {
        return name;
    }

    private static void validateCoachName(String coachName) {
        if (coachName.length() < CoachConstant.MIN_COACH_NAME_LENGTH.getNum()
            || coachName.length() > CoachConstant.MAX_COACH_NAME_LENGTH.getNum()) {
            throw new IllegalArgumentException();
        }
    }
}
