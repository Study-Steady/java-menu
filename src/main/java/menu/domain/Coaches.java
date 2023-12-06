package menu.domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public int getCoachCount() {
        return coaches.size();
    }

    public Coach getCoachBy(int index) {
        return coaches.get(index);
    }

    public String getCoachNameBy(int index) {
        return getCoachBy(index).getName();
    }

    public List<String> getRecommendMenusBy(int index) {
        return getCoachBy(index).getRecommendMenus();
    }
}
