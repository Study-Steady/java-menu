package menu.domain.menu;

import static menu.domain.menu.MenuCategory.ASIAN;
import static menu.domain.menu.MenuCategory.CHINESE;
import static menu.domain.menu.MenuCategory.JAPANESE;
import static menu.domain.menu.MenuCategory.KOREAN;
import static menu.domain.menu.MenuCategory.WESTERN;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    규동("규동", JAPANESE), 우동("우동", JAPANESE), 미소시루("미소시루", JAPANESE), 스시("스시", JAPANESE), 가츠동("가츠동", JAPANESE), 오니기리(
            "오니기리", JAPANESE), 하이라이스("하이라이스", JAPANESE), 라멘("라멘", JAPANESE), 오코노미야끼("오코노미야끼", JAPANESE),
    김밥("김밥", KOREAN), 김치찌개("김치찌개", KOREAN), 쌈밥("쌈밥", KOREAN), 된장찌개("된장찌개", KOREAN), 비빔밥("비빔밥", KOREAN), 칼국수("칼국수",
            KOREAN), 불고기("불고기", KOREAN), 떡볶이("떡볶이", KOREAN), 제육볶음("제육볶음", KOREAN),
    깐풍기("깐풍기", CHINESE), 볶음면("볶음면", CHINESE), 동파육("동파육", CHINESE), 짜장면("짜장면", CHINESE), 짬뽕("짬뽕", CHINESE), 마파두부("마파두부",
            CHINESE), 탕수육("탕수육", CHINESE), 토마토_달걀볶음("토마토 달걀볶음", CHINESE), 고추잡채("고추잡채", CHINESE),
    팟타이("팟타이", ASIAN), 카오_팟("카오 팟", ASIAN), 나시고렝("나시고렝", ASIAN), 파인애플_볶음밥("파인애플 볶음밥", ASIAN), 쌀국수("쌀국수", ASIAN), 똠얌꿍(
            "똠양꿍", ASIAN), 반미("반미", ASIAN), 월남쌈("월남쌈", ASIAN), 분짜("분짜", ASIAN),
    라자냐("라자냐", WESTERN), 그라탱("그라탱", WESTERN), 뇨끼("뇨끼", WESTERN), 끼슈("끼슈", WESTERN), 프렌치_토스트("프렌치 토스트", WESTERN), 바게트(
            "바게트", WESTERN), 스파게티("스파게티", WESTERN), 피자("피자", WESTERN), 파니니("파니니", WESTERN),
    ;

    private final String name;
    private final MenuCategory menuCategory;

    Menu(String name, MenuCategory menuCategory) {
        this.name = name;
        this.menuCategory = menuCategory;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public static List<Menu> getMenusByMenuCategory(MenuCategory menuCategory) {
        return MENUS_BY_MENU_CATEGORY.get(menuCategory);
    }

    public static Menu fromName(String name) {
        return BY_NAME.get(name);
    }

    // todo 최적화
    private static Map<MenuCategory, List<Menu>> MENUS_BY_MENU_CATEGORY = Map.of(
            JAPANESE, List.of(규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼),
            KOREAN, List.of(김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음),
            CHINESE, List.of(깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토_달걀볶음, 고추잡채),
            ASIAN, List.of(팟타이, 카오_팟, 나시고렝, 파인애플_볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜),
            WESTERN, List.of(라자냐, 그라탱, 뇨끼, 끼슈, 프렌치_토스트, 바게트, 스파게티, 피자, 파니니)
    );

    private static Map<String, Menu> BY_NAME =
            Stream.of(values())
                    .collect(
                            Collectors.toMap(
                                    Menu::getName,
                                    menu -> menu
                            )
                    );
}
