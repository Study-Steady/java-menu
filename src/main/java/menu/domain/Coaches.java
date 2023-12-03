package menu.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Coaches {
    private static final int MIN_COACHES_COUNT = 2;
    private static final int MAX_COACHES_COUNT = 5;
    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(List<Coach> coaches) {
        validateCoachCount(coaches);
        validateDuplicate(coaches);
        return new Coaches(coaches);
    }

    private static void validateCoachCount(List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES_COUNT || coaches.size() > MAX_COACHES_COUNT) {
            throw new IllegalArgumentException("코치의 수는 최소 2명 최대 5명이어야 합니다.");
        }
    }

    private static void validateDuplicate(List<Coach> coaches) {
        Set<String> duplicationNames = getDuplicationCoaches(coaches);
        if (coaches.size() != duplicationNames.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private static Set<String> getDuplicationCoaches(List<Coach> coaches) {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toSet());
    }

    public int getCoachCount() {
        return coaches.size();
    }

    public String getCoachNameBy(int index) {
        return coaches.get(index).getName();
    }
}
