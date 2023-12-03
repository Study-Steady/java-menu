package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomMenusPicker implements MenusPicker {
    @Override
    public Menu pick(List<String> menus, Player player) {
        Menu menu = Menu.from("");
        while (!player.isAvoidedMenu(menu) && !player.recommanedMenu(menu)) {
            menu = Menu.from(Randoms.shuffle(menus).get(0));
        }
        return menu;
    }
}
