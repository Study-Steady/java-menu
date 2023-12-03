package menu.utils;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DayOfWeek {
    MONDAY("월요일", 1),
    TUESDAY("화요일", 2),
    WEDNESDAY("수요일", 3),
    THURSDAY("목요일", 4),
    FRIDAY("금요일", 5),
    ;

    private final String dayOfWeek;
    private final int dayOfWeekNumber;

    DayOfWeek(String dayOfWeek, int dayOfWeekNumber) {
        this.dayOfWeek = dayOfWeek;
        this.dayOfWeekNumber = dayOfWeekNumber;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfWeekNumber() {
        return dayOfWeekNumber;
    }

    public static DayOfWeek fromNum(int dayOfWeekNumber) {
        return BY_NUM.get(dayOfWeekNumber);
    }

    private static Map<Integer, DayOfWeek> BY_NUM =
            Stream.of(values()).collect(
                    Collectors.toMap(DayOfWeek::getDayOfWeekNumber, e -> e));
}
