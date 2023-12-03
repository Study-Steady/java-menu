package menu.domain.coach;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Coaches {

    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(List<Coach> coaches) {
        validateCoachSize(coaches);
        return new Coaches(coaches);
    }

    private static void validateCoachSize(List<Coach> coaches) {
        if (!meetsCoachSizeCriterion(coaches)) {
            throw new IllegalArgumentException("식사를 함께하기 위한 코치 인원수 조건이 맞지 않습니다.");
        }
    }

    private static boolean meetsCoachSizeCriterion(List<Coach> coaches) {
        if (Objects.isNull(coaches) || coaches.isEmpty()) {
            return false;
        }
        return coaches.size() >= MIN_COACH_SIZE && coaches.size() <= MAX_COACH_SIZE;
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

}
