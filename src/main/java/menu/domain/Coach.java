package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private String name;
    private InedibleMenus inedibleMenus;
    private List<String> recommendMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void updateInedibleMenus(String menuNames) {
        inedibleMenus = InedibleMenus.from(menuNames);
    }

    public boolean isInedibleMenu(String menuName) {
        return inedibleMenus.isInedibleMenu(menuName);
    }

    public boolean alreadyRecommended(String menuName) {
        return recommendMenus.contains(menuName);
    }

    public void recommended(String menuName) {
        recommendMenus.add(menuName);
    }

    public List<String> getRecommendMenus() {
        return Collections.unmodifiableList(recommendMenus);
    }
}
