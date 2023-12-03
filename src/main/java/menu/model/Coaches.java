package menu.model;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.");
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
            coach.recommendMenu(menuNames, picker);
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
