package menu.domain.coach;

import static menu.utils.MenuUtils.getRandomMenu;

import java.util.function.Consumer;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;

public class Coach {
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_NAME_LENGTH = 2;

    private final String name;
    private final MenuHistory menuHistory;

    private Coach (String name, MenuHistory menuHistory) {
        this.name = name;
        this.menuHistory = menuHistory;
    }

    public static Coach of(String name) {
        validateName(name);
        return new Coach(name, MenuHistory.create());
    }

    public void addMenuFromCategory(MenuCategory category) {
        process(menuHistory::addMenu, category);
    }

    public String getName() {
        return name;
    }

    public MenuHistory getMenuHistory() {
        return menuHistory;
    }

    private void process(Consumer<Menu> consumer, MenuCategory category) {
        try {
            consumer.accept(getRandomMenu(category));
        } catch (IllegalArgumentException e) {
            // todo : 예외처리 메세지 출력
            process(consumer, category);
        }
    }

    private static void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
