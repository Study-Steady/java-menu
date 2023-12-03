package menu.domain;

import java.util.EnumMap;
import java.util.Map;

public class WeeklyMenus {
    private final Map<Day, Menu> weekylMenus;

    public WeeklyMenus(Map<Day, Menu> weekylMenus) {
        this.weekylMenus = weekylMenus;
    }

    public void add(Day day, Menu menu) {
        weekylMenus.put(day, menu);
    }
    public static WeeklyMenus init() {
        Map<Day, Menu> weekylMenus = new EnumMap<>(Day.class);
        return new WeeklyMenus(weekylMenus);
    }

    public boolean contains(Menu inputMenu) {
        return weekylMenus.values().stream()
                 .anyMatch(menu -> menu.equals(inputMenu));
    }

    public Map<Day, Menu> getWeekylMenus() {
        return weekylMenus;
    }
}
