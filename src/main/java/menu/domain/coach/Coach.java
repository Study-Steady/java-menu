package menu.domain.coach;

import menu.domain.menu.Menu;
import menu.domain.menu.MenuBlackList;
import menu.domain.menu.MenuHistory;

public class Coach {
    private final CoachName name;
    private final MenuHistory menuHistory;
    private final MenuBlackList menuBlackList;

    private Coach(CoachName name, MenuHistory menuHistory, MenuBlackList menuBlackList) {
        this.name = name;
        this.menuHistory = menuHistory;
        this.menuBlackList = menuBlackList;
    }

    public static Coach of(CoachName name, MenuBlackList menuBlackList) {
        return new Coach(name, MenuHistory.create(), menuBlackList);
    }

    public void addMenu(Menu menu) {
        if (menuBlackList.contains(menu)) {
            throw new IllegalArgumentException();
        }
        menuHistory.addMenu(menu);
    }

    public CoachName getName() {
        return name;
    }

    public MenuHistory getMenuHistory() {
        return menuHistory;
    }
}
