package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private String name;
    private InedibleMenus inedibleMenus;
    private List<String> recommendMenus = new ArrayList<>();

    public Coach(String name, InedibleMenus inedibleMenus) {
        this.name = name;
        this.inedibleMenus = inedibleMenus;
    }

    public String getName() {
        return name;
    }

    public boolean isInedibleMenu(String name) {
        return inedibleMenus.isInedibleMenu(name);
    }

    public void recommended(String menuName) {
        recommendMenus.add(menuName);
    }

    public List<String> getRecommendMenus() {
        return Collections.unmodifiableList(recommendMenus);
    }
}
