package menu.domain.coach;

import java.util.Set;
import menu.domain.menu.Menu;

public class Coach {
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_NAME_LENGTH = 2;

    private final String name;
    private final MenuHistory menuHistory;
    private final MenuBlackList menuBlackList;

    private Coach (String name, MenuHistory menuHistory, MenuBlackList menuBlackList) {
        this.name = name;
        this.menuHistory = menuHistory;
        this.menuBlackList = menuBlackList;
    }

    public static Coach of(String name, Set<String> rawBlackList) {
        validateName(name);
        return new Coach(name, MenuHistory.create(), MenuBlackList.from(rawBlackList));
    }

    public void addMenu(Menu menu) {
        if (menuBlackList.contains(menu)) {
            throw new IllegalArgumentException();
        }
        menuHistory.addMenu(menu);
    }

    public String getName() {
        return name;
    }

    public MenuHistory getMenuHistory() {
        return menuHistory;
    }

    private static void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
