package menu.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WeeklyCategories {
    private final Map<Day, Category> weeklyCategories;
    private final MenusPicker menusPicker;

    public WeeklyCategories(Map<Day, Category> weeklyCategories, MenusPicker menusPicker) {
        this.weeklyCategories = weeklyCategories;
        this.menusPicker = menusPicker;
    }

    public static WeeklyCategories of(Categories categories, MenusPicker menusPicker) {
        return new WeeklyCategories(convertToWeeklyCategories(categories), menusPicker);
    }

    private static Map<Day, Category> convertToWeeklyCategories(Categories rawCategories) {
        Map<Day, Category> weeklyCatergories = new EnumMap<>(Day.class);
        Day[] days = Day.values();
        List<Category> categories = rawCategories.getCategories();

        for (int index = 0; index < days.length; index++) {
            weeklyCatergories.put(days[index], categories.get(index));
        }
        return weeklyCatergories;
    }

    public void recommandMenus(Players players) {
        weeklyCategories.forEach((day, category) -> category.recommandMenus(day, players, menusPicker));
    }

    public Map<Day, Category> getWeeklyCategories() {
        return weeklyCategories;
    }
}
