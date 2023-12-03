package menu.model;

public class RecommendSystem {
    private final MenuCategory menuCategory;
    private final Coaches coaches;

    public RecommendSystem(MenuCategory menuCategory, Coaches coaches) {
        this.menuCategory = menuCategory;
        this.coaches = coaches;
    }

    public static RecommendSystem of(MenuCategory menuCategory, Coaches coaches) {
        return new RecommendSystem(menuCategory, coaches);
    }
}
