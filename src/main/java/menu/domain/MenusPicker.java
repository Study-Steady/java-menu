package menu.domain;

import java.util.List;

public interface MenusPicker {
    Menu pick(List<String> menus, Player player);
}
