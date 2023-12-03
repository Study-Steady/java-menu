package menu.utils;

import menu.domain.menu.Menu;

public class StringUtils {
    private StringUtils() {
    }

    public static Menu convertStringToMenu(String input) {
        return Menu.fromName(input);
    }
}
