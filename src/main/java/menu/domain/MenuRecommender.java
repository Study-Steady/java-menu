package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRecommender {
    private static final int FIRST_VALUE = 0;
    private static final int MIN_CATEGORY_RANGE = 1;
    private static final int MAX_CATEGORY_RANGE = 5;
    private static final int MAX_CATEGORY_DUPLICATION_COUNT = 2;

    private MenuRecommender() {
    }

    public static String recommendMenu(Coach coach, Menu menu) {
        String menuName = Randoms.shuffle(menu.getNames()).get(FIRST_VALUE);
        while (coach.isInedibleMenu(menuName) && !coach.alreadyRecommended(menuName)) {
            menuName = Randoms.shuffle(menu.getNames()).get(FIRST_VALUE);
        }
        return menuName;
    }

    public static Category recommendCategories() {
        List<Menu> categories = new ArrayList<>();
        while (categories.size() < MAX_CATEGORY_RANGE) {
            Menu menu = Menu.findMatchesCategory(Randoms.pickNumberInRange(MIN_CATEGORY_RANGE, MAX_CATEGORY_RANGE)).get();
            categories.add(menu);
            if (isDuplicateCountMoreThanTwo(categories)) {
                categories.clear();
            }
        }
        return new Category(categories);
    }

    private static boolean isDuplicateCountMoreThanTwo(List<Menu> categories) {
        Map<String, Long> duplicateCountMap = getDuplicatedCountMap(categories);
        for (Long count : duplicateCountMap.values()) {
            if (count > MAX_CATEGORY_DUPLICATION_COUNT) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Long> getDuplicatedCountMap(List<Menu> categories) {
        return categories.stream()
                .collect(Collectors.groupingBy(Menu::getCategoryName, Collectors.counting()));
    }
}
