package menu.domain.coach;

import java.util.Set;
import menu.domain.menu.Menu;

public class Coach {
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_NAME_LENGTH = 2;

    // private final String name;
    private final CoachName name;
    private final MenuHistory menuHistory;
    private final MenuBlackList menuBlackList;

    private Coach (CoachName name, MenuHistory menuHistory, MenuBlackList menuBlackList) {
        this.name = name;
        this.menuHistory = menuHistory;
        this.menuBlackList = menuBlackList;
    }

    public static Coach of(CoachName name, Set<String> rawBlackList) {
        return new Coach(name, MenuHistory.create(), MenuBlackList.from(rawBlackList));
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
