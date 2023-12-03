package menu.domain.coach;

import static menu.utils.MenuUtils.getRandomMenu;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;

public class CoachManager {
    private final List<Coach> coaches;

    private CoachManager(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static CoachManager from(List<Coach> coaches) {
        return new CoachManager(coaches);
    }

    public void addMenusEachFromMenuCategory(MenuCategory menuCategory) {
        coaches.forEach(
                c -> process(c::addMenu, menuCategory)
        );
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    private void process(Consumer<Menu> consumer, MenuCategory category) {
        try {
            consumer.accept(getRandomMenu(category));
        } catch (IllegalArgumentException e) {
            // todo : 예외처리 메세지 출력
            System.out.println("예외 발생");
            process(consumer, category);
        }
    }
}
