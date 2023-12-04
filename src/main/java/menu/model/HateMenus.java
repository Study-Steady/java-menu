package menu.model;

import java.util.ArrayList;
import java.util.List;

public class HateMenus {
    private static final int MAX_HATE_MENU_COUNT = 2;

    private final List<Menu> menus;

    HateMenus(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<Menu> menus) {
        if (menus.size() > MAX_HATE_MENU_COUNT) {
            throw new IllegalArgumentException("싫어하는 음식은 최소 0게 최대 2개까지만 가능합니다.");
        }
        if (menus.stream().distinct().count() != menus.size()) {
            throw new IllegalArgumentException("싫어하는 음식은 중복되지 않아야 합니다.");
        }
    }

    public static HateMenus from(List<String> rawHateMenus) {
        List<Menu> hateMenus = rawHateMenus.stream()
                .filter(rawHateMenu -> !rawHateMenu.isBlank())
                .map(Menu::from)
                .toList();

        return new HateMenus(hateMenus);
    }

    public static HateMenus defaultOf() {
        return new HateMenus(new ArrayList<>());
    }

    public boolean notInclude(Menu menu) {
        return !this.menus.contains(menu);
    }

    public void addMenus(HateMenus hateMenus) {
        this.menus.addAll(hateMenus.menus);
    }
}
