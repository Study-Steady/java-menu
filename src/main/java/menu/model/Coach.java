package menu.model;

import java.util.List;
import java.util.stream.Stream;

public class Coach {
    private final CoachName name;
    private final HateMenus hateMenus;
    private final RecommendMenus recommendMenus;

    Coach(CoachName name, HateMenus hateMenus, RecommendMenus recommendMenus) {
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

    public void addHateMenus(HateMenus hateMenus) {
        this.hateMenus.addMenus(hateMenus);
    }

    public void recommendedMenu(List<String> menuNames, Picker picker) {
        Stream.generate(() -> getRandomMenu(menuNames, picker))
                .filter(recommendMenu -> recommendMenu.notIn(hateMenus))
                .filter(recommendMenu -> recommendMenu.notIn(recommendMenus))
                .findFirst()
                .ifPresent(recommendMenus::addMenu);
    }

    private static Menu getRandomMenu(List<String> menuNames, Picker picker) {
        String menuName = picker.pickOne(menuNames);
        return Menu.from(menuName);
    }

    public CoachName getName() {
        return name;
    }

    public RecommendMenus getRecommendMenus() {
        return recommendMenus;
    }
}
