package menu.domain.coach;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import menu.domain.menu.Menu;

public class RestrictedMenu {

    private static final int MIN_RESTRICTED_MENU_SIZE = 0;
    private static final int MAX_RESTRICTED_MENU_SIZE = 2;

    private final List<Menu> menu;

    private RestrictedMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public static RestrictedMenu from(List<Menu> menu) {
        validateMenuSize(menu);
        return new RestrictedMenu(menu);
    }

    private static void validateMenuSize(List<Menu> menu) {
        if (!meetsRestrictedMenuSizeCriterion(menu)) {
            throw new IllegalArgumentException("먹지 못하는 메뉴 개수 제한 조건이 맞지 않습니다.");
        }
    }

    private static boolean meetsRestrictedMenuSizeCriterion(List<Menu> menu) {
        if (Objects.isNull(menu)) {
            return false;
        }
        return menu.size() >= MIN_RESTRICTED_MENU_SIZE && menu.size() <= MAX_RESTRICTED_MENU_SIZE;
    }

    public List<Menu> getMenu() {
        return Collections.unmodifiableList(menu);
    }

    public boolean contains(Menu menu) {
        return this.menu.contains(menu);
    }

}
