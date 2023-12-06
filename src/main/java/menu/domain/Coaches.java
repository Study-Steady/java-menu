package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.StringConvertor;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(String inputCoachNames) {
        String[] coachNames = StringConvertor.splitByComma(inputCoachNames);
        List<Coach> coaches = Arrays.stream(coachNames)
                .map(coachName -> new Coach(coachName))
                .collect(Collectors.toList());
        return new Coaches(coaches);
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

    public void updateInedibleMenusBy(int index, String menuName) {
        getCoachBy(index).updateInedibleMenus(menuName);
    }
}
