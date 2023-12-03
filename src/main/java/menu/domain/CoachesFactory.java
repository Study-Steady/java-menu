package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.StringConvertor;

public class CoachesFactory {

    private CoachesFactory() {
    }

    public static Coaches createCoachesBy(String inputCoaches) {
        List<Coach> coaches = Arrays.stream(StringConvertor.splitByComma(inputCoaches))
                .map(Coach::from)
                .collect(Collectors.toUnmodifiableList());
        return Coaches.from(coaches);
    }
}
