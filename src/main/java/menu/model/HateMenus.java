package menu.model;

import java.util.ArrayList;
import java.util.List;

public class HateMenus {
    private final List<Menu> menus;

    public HateMenus(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<Menu> menus) {
        if (menus.size() > 3) {
            throw new IllegalArgumentException("싫어하는 음식은 최소 0게 최대 2개까지만 가능합니다.");
        }
    }

    public static HateMenus defaultOf() {
        return new HateMenus(new ArrayList<>());
    }

    public void addMenus(List<Menu> hateMenus) {
        List<Menu> filteredHateMenus = hateMenus.stream()
                .filter(Menu::isValidMenu)
                .toList();

        this.menus.addAll(filteredHateMenus);
    }
}
