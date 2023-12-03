package menu.utils;

import static menu.utils.DefaultSymbol.DELIMETER;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachName;
import menu.domain.menu.Menu;

public class StringUtils {
    private StringUtils() {
    }

    public static Menu convertStringToMenu(String input) {
        return Menu.fromName(input);
    }

    public static List<String> splitStringByDelimter(String input) {
        String[] rawCoachNames = input.split(DELIMETER.getSymbol());
        return List.of(rawCoachNames);
    }

    public static List<CoachName> convertStringToCoachNames(String rawCoachNames) {
        String[] coachNames = rawCoachNames.split(DELIMETER.getSymbol());
        return Arrays.stream(coachNames)
                .map(CoachName::from)
                .collect(Collectors.toList());
    }

    public static Set<String> splitStringByDelimeterAndConvertToSet(String input) {
        String[] rawCoachNames = input.split(DELIMETER.getSymbol());
        return Set.of(rawCoachNames);
    }
}