package menu.model;

import java.util.List;

public class Coach {
    private final CoachName name;
    private final HateMenus hateMenus;
    private final RecommendMenus recommendMenus;

    private Coach(CoachName name, HateMenus hateMenus, RecommendMenus recommendMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
        this.recommendMenus = recommendMenus;
    }

    public static Coach from(String name) {
        CoachName coachName = CoachName.from(name);
        HateMenus hateMenus = HateMenus.defaultOf();
        RecommendMenus recommendMenus = RecommendMenus.defaultOf();

        return new Coach(coachName, hateMenus, recommendMenus);
    }

    public void addHateMenus(List<Menu> hateMenus) {
        this.hateMenus.addMenus(hateMenus);
    }

    public CoachName getName() {
        return name;
    }
}
