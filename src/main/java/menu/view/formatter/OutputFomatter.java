package menu.view.formatter;

import java.util.stream.Collectors;
import menu.common.Symbol;
import menu.domain.Categories;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Player;
import menu.domain.WeeklyMenus;

public class OutputFomatter {
    public static final String WORD_SEPARATOR = Symbol.BAR;

    public static String toCategories(Categories rawCategories) {
        return rawCategories.getCategories().stream()
                .map(Category::getMessage)
                .collect(Collectors.joining(" " + WORD_SEPARATOR + " "));
    }

    public static String toPlayerName(Player player) {
        return player.getPlayerName().getPlayerName();
    }

    public static String toMenus(Player player) {
        WeeklyMenus weeklyMenus = player.getWeeklyMenus();
        return weeklyMenus.getWeekylMenus().values().stream()
                .map(Menu::getMenu)
                .collect(Collectors.joining(" " + WORD_SEPARATOR + " "));
    }
}
