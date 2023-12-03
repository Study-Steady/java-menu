package menu.domain;

import java.util.Objects;

public class Menu {
    private final String menu;

    public Menu(String menu) {
        this.menu = menu;
    }

    public static Menu from(String menu) {
        return new Menu(menu);
    }

    public boolean isSameMenu(String avoidedMenu) {
        return avoidedMenu.equals(menu);
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu1 = (Menu) o;
        return Objects.equals(menu, menu1.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}
