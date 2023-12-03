package menu.view.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;
import menu.domain.recommend.MenuRecommendResult;
import menu.view.CharacterSymbol;

public class OutputFormatter {

    private OutputFormatter() {
    }

    public static String toMenuRecommendFormat(MenuRecommendResult menuRecommendResult) {
        Coach coach = menuRecommendResult.getCoach();
        List<Menu> recommendedMenu = menuRecommendResult.getRecommendedMenu();

        List<String> strings = new ArrayList<>();
        strings.add(coach.getName());
        strings.addAll(recommendedMenu.stream().map(Menu::getName).collect(Collectors.toList()));

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
