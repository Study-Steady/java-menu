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

    public String getCoachNameBy(int index) {
        return coaches.get(index).getName();
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }
}
