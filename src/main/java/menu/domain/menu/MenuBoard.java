package menu.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuBoard {

    JAPANESE(MenuCategory.JAPANESE, List.of(
            new Menu("규동"),
            new Menu("우동"),
            new Menu("미소시루"),
            new Menu("스시"),
            new Menu("가츠동"),
            new Menu("오니기리"),
            new Menu("하이라이스"),
            new Menu("라멘"),
            new Menu("오코노미야끼")
    )),
    KOREAN(MenuCategory.KOREAN, List.of(
            new Menu("김밥"),
            new Menu("김치찌개"),
            new Menu("쌈밥"),
            new Menu("된장찌개"),
            new Menu("비빔밥"),
            new Menu("칼국수"),
            new Menu("불고기"),
            new Menu("떡볶이"),
            new Menu("제육볶음")
    )),
    CHINESE(MenuCategory.CHINESE, List.of(
            new Menu("깐풍기"),
            new Menu("볶음면"),
            new Menu("동파육"),
            new Menu("짜장면"),
            new Menu("짬뽕"),
            new Menu("마파두부"),
            new Menu("탕수육"),
            new Menu("토마토 달걀볶음"),
            new Menu("고추잡채")
    )),
    ASIAN(MenuCategory.ASIAN, List.of(
            new Menu("팟타이"),
            new Menu("카오 팟"),
            new Menu("나시고렝"),
            new Menu("파인애플 볶음밥"),
            new Menu("쌀국수"),
            new Menu("똠얌꿍"),
            new Menu("반미"),
            new Menu("월남쌈"),
            new Menu("분짜")
    )),
    WESTERN(MenuCategory.WESTERN, List.of(
            new Menu("라자냐"),
            new Menu("그라탱"),
            new Menu("뇨끼"),
            new Menu("끼슈"),
            new Menu("프렌치 토스트"),
            new Menu("바게트"),
            new Menu("스파게티"),
            new Menu("피자"),
            new Menu("파니니")
    ));

    private final MenuCategory category;
    private final List<Menu> menu;

    MenuBoard(MenuCategory category, List<Menu> menu) {
        this.category = category;
        this.menu = menu;
    }

    public static List<String> getMenuNamesByCategory(MenuCategory category) {
        return getByCategory(category).getMenuNames();
    }

    private static MenuBoard getByCategory(MenuCategory category) {
        return Arrays.stream(MenuBoard.values())
                .filter(menuBoard -> menuBoard.matchesCategory(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Menuboard exist for category=%s", category.toString()))
                );
    }

    public static Menu getMenuBy(MenuCategory category, String menuName) {
        return getByCategory(category).getMenuByName(menuName);
    }

    private Menu getMenuByName(String menuName) {
        return this.menu.stream()
                .filter(menu -> menu.matchesName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Menu exists for menuName=%s", menuName)
                ));
    }

    private boolean matchesCategory(MenuCategory category) {
        return this.category.equals(category);
    }

    public List<String> getMenuNames() {
        return this.menu.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

}

