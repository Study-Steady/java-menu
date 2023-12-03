package menu.model;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenus {
    private final List<Menu> menus;

    public RecommendMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public static RecommendMenus defaultOf() {
        return new RecommendMenus(new ArrayList<>());
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
