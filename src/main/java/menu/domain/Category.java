package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN(1,  "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식",  List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4,"아시안",  List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5,"양식",  List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")),
    DEFAULT(0,"",  List.of());
    private final int index;
    private final String message;
    private final List<String> menus;

    Category(int index, String message, List<String> menus) {
        this.index = index;
        this.message = message;
        this.menus = menus;
    }

    public static Category fromIndex(int index) {
        return Arrays.stream(values())
                .filter(category -> category.index == index)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 카테고리 순서입니다."));
    }

    public void recommandMenus(Day day, Players players, MenusPicker menusPicker) {
        players.getPlayer().forEach(player -> {
            Menu menu = menusPicker.pick(menus, player);
            player.applyRecommandMenus(day, menu);
        });
    }

    public String getMessage() {
        return message;
    }
}
