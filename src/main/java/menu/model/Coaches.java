package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;

    private final List<Coach> coaches;

    Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = new ArrayList<>(coaches);
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < MIN_COACH_COUNT || coaches.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(
                    String.format("코치는 최소 %d명, 최대 %d명까지 식사를 함께 합니다.", MIN_COACH_COUNT, MAX_COACH_COUNT));
        }
    }

    public static Coaches from(List<String> rawCoachNames) {
        List<Coach> coaches = rawCoachNames.stream()
                .map(Coach::from)
                .toList();

        return new Coaches(coaches);
    }

    public void recommendMenus(List<String> menuNames, Picker picker) {
        for (Coach coach : coaches) {
            coach.recommendedMenu(menuNames, picker);
        }
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches);
    }
}
