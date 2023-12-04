package menu.model;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenus {
    private final List<Menu> menus;

    public RecommendMenus(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<Menu> menus) {
        if (menus.isEmpty()) {
            throw new IllegalArgumentException("추천 메뉴는 최소 1개 이상이어야 합니다.");
        }
        if (menus.stream().distinct().count() != menus.size()) {
            throw new IllegalArgumentException("추천 메뉴는 중복되지 않아야 합니다.");
        }
    }

    public static RecommendMenus defaultOf() {
        return new RecommendMenus(new ArrayList<>());
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public boolean notInclude(Menu menu) {
        return !this.menus.contains(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
