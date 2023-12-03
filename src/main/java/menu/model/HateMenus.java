package menu.model;

import java.util.ArrayList;
import java.util.List;

public class HateMenus {
    private final List<Menu> menus;

    HateMenus(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<Menu> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("싫어하는 음식은 최소 0게 최대 2개까지만 가능합니다.");
        }
    }

    public static HateMenus from(List<String> rawHateMenus) {
        List<Menu> hateMenus = rawHateMenus.stream()
                .map(Menu::from)
                .toList();

        return new HateMenus(hateMenus);
    }

    public static HateMenus defaultOf() {
        return new HateMenus(new ArrayList<>());
    }

    public boolean isNotHateMenu(Menu recommendedMenu) {
        return menus.stream()
                .noneMatch(menu -> menu.equals(recommendedMenu));
    }

    public void addMenus(HateMenus hateMenus) {
        this.menus.addAll(hateMenus.menus);
    }
}
