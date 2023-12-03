package menu.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {

    JAPANESE_MENU(MenuType.JAPANESE, List.of(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_MENU(MenuType.KOREAN, List.of(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_MENU(MenuType.CHINESE, List.of(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_MENU(MenuType.ASIAN, List.of(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_MENU(MenuType.WESTERN, List.of(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    final MenuType type;
    final List<String> names;

    Menu(MenuType type, List<String> names) {
        this.type = type;
        this.names = names;
    }

    public static List<String> getMenuNamesByType(MenuType menuType) {
        return Arrays.stream(values())
                .filter(menu -> menu.type == menuType)
                .flatMap(menu -> menu.names.stream())
                .collect(Collectors.toList());
    }
}