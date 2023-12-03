package menu.domain.menu;

import java.util.Set;
import java.util.stream.Collectors;

public class MenuBlackList {
    private static final int MAX_BLACK_LIST_SIZE = 2;

    private final Set<Menu> blackList;

    private MenuBlackList(Set<Menu> blackList) {
        this.blackList = blackList;
    }

    public static MenuBlackList from(Set<String> rawBlackList) {
        validateBlackListSize(rawBlackList);
        Set<Menu> blackList = rawBlackList.stream()
                .map(Menu::fromName)
                .collect(Collectors.toSet());
        return new MenuBlackList(blackList);
    }

    public boolean contains(Menu menu) {
        return blackList.contains(menu);
    }

    private static void validateBlackListSize(Set<String> rawBlackList) {
        if (rawBlackList.size() > MAX_BLACK_LIST_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
