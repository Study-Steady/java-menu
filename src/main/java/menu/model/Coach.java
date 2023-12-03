package menu.model;

public class Coach {
    private final CoachName name;
    private final HateMenu hateMenu;
    private final RecommendMenu recommendMenu;

    private Coach(CoachName name, HateMenu hateMenu, RecommendMenu recommendMenu) {
        this.name = name;
        this.hateMenu = hateMenu;
        this.recommendMenu = recommendMenu;
    }

    public static Coach from(String name) {
        CoachName coachName = CoachName.from(name);
        HateMenu hateMenu = HateMenu.defaultOf();
        RecommendMenu recommendMenu = RecommendMenu.defaultOf();

        return new Coach(coachName, hateMenu, recommendMenu);
    }
}
