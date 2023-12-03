package menu.model;

import java.util.ArrayList;
import java.util.List;

public class HateMenu {
    private final List<Menu> menus;

    public HateMenu(List<Menu> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<Menu> menus) {
        if (menus.size() > 3) {
            throw new IllegalArgumentException("싫어하는 음식은 최소 0게 최대 2개까지만 가능합니다.");
        }
    }

    public static HateMenu defaultOf() {
        return new HateMenu(new ArrayList<>());
    }
}
