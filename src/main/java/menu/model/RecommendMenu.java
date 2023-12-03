package menu.model;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenu {
    private final List<Menu> menus;

    public RecommendMenu(List<Menu> menus) {
        this.menus = menus;
    }

    public static RecommendMenu defaultOf() {
        return new RecommendMenu(new ArrayList<>());
    }
}
