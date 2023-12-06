package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {
    private static final int MAX_MENU_SIZE = 5;

    private MenuRecommender() {
    }

    public static String recommendMenu(Coach coach, Menu menu) {
        String menuName = Randoms.shuffle(menu.getNames()).get(0);
        while (coach.isInedibleMenu(menuName)) {
            menuName = Randoms.shuffle(menu.getNames()).get(0);
        }
        return menuName;
    }

    public static List<Menu> recommendCategories() {
        Map<Menu, Integer> categoryCount = new HashMap<>();
        List<Menu> categories = new ArrayList<>();
        while (categories.size() < MAX_MENU_SIZE) {
            Menu menu = Menu.findMatchesCategory(Randoms.pickNumberInRange(1, 5)).get();
            if (categoryCount.getOrDefault(menu, 0) >= 2) {
                continue;
            }
            categoryCount.put(menu, categoryCount.getOrDefault(menu, 0) + 1);
            categories.add(menu);
        }
        return categories;
    }
}
