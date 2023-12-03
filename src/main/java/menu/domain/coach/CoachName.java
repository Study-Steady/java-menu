package menu.domain.coach;

import java.util.List;
import java.util.stream.Collectors;

public class CoachName {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    
    public CoachName(String name) {
        this.name = name;
    }

    public static CoachName nameOf(String name) {
        validateNameLength(name);
        return new CoachName(name);
    }

    private static void validateNameLength(String name) {
        if (!meetsNameLengthCriterion(name)) {
            throw new IllegalArgumentException("이름 길이 조건이 맞지 않습니다.");
        }
    }

    private static boolean meetsNameLengthCriterion(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public static List<CoachName> namesOf(List<String> nameLiterals) {
        return nameLiterals.stream()
                .map(CoachName::nameOf)
                .collect(Collectors.toList());
    }

    public String getName() {
        return this.name;
    }

}
