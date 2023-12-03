package menu.domain.coach;

import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.menu.Menu;

public class MenuBlackList {
    private final Set<Menu> blackList;

    private MenuBlackList(Set<Menu> blackList) {
        this.blackList = blackList;
    }

    public static MenuBlackList from(Set<String> rawBlackList) {
        Set<Menu> blackList = rawBlackList.stream()
                .map(Menu::fromName)
                .collect(Collectors.toSet());
        return new MenuBlackList(blackList);
    }

    public boolean contains(Menu menu) {
        return blackList.contains(menu);
    }
}
