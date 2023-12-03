package menu.view.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;
import menu.view.CharacterSymbol;

public class OutputFormatter {

    private OutputFormatter() {
    }

    public static String toCategoryFormat(List<MenuCategory> menuCategories) {
        List<String> strings = new ArrayList<>();
        strings.add("카테고리");
        strings.addAll(
                menuCategories.stream()
                        .map(MenuCategory::getDescription)
                        .collect(Collectors.toList())
        );

        String formatted = strings.stream()
                .map(string -> CharacterSymbol.BLANK.getLiteral() + string + CharacterSymbol.BLANK.getLiteral())
                .collect(Collectors.joining("|"));

        return new StringBuilder()
                .append("[")
                .append(formatted)
                .append("]")
                .toString();
    }

    public static String toMenuRecommendFormat(Coach coach) {
        List<String> strings = new ArrayList<>();
        strings.add(coach.getName());
        strings.addAll(
                coach.getRecommended().stream()
                        .map(Menu::getName)
                        .collect(Collectors.toList())
        );

        return new StringBuilder()
                .append("[")
                .append(toFormat(strings))
                .append("]")
                .toString();
    }

    private static String toFormat(List<String> strings) {
        return strings.stream()
                .map(string -> CharacterSymbol.BLANK.getLiteral() + string + CharacterSymbol.BLANK.getLiteral())
                .collect(Collectors.joining("|"));
    }

}
