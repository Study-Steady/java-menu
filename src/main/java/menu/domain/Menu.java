package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public enum Menu {
    JAPANESE("일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"), 1),
    KOREAN("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"), 2),
    CHINESE("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"), 3),
    ASIAN("아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"), 4),
    WESTERN("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"), 5);

    private final String categoryName;
    private final List<String> names;
    private final int menuCondition;

    Menu(String categoryName, List<String> names, int menuCondition) {
        this.categoryName = categoryName;
        this.names = names;
        this.menuCondition = menuCondition;
    }

    public static Optional<Menu> findMatchesCategory(int randomNumber) {
        return EnumSet.allOf(Menu.class).stream()
                .filter(menu -> menu.menuCondition == randomNumber)
                .findFirst();
    }

    public static boolean containsMenu(String name) {
        return EnumSet.allOf(Menu.class).stream()
                .anyMatch(menu -> menu.contains(name));
    }

    public boolean contains(String name) {
        return names.contains(name);
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }

    public String getCategoryName() {
        return categoryName;
    }
}
