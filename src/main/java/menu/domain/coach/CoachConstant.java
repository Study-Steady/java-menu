package menu.domain.coach;

public enum CoachConstant {
    MIN_COACH_NUM(2),
    MAX_COACH_NUM(5),
    MIN_COACH_NAME_LENGTH(2),
    MAX_COACH_NAME_LENGTH(4),
    ;

    private final int num;

    CoachConstant(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
