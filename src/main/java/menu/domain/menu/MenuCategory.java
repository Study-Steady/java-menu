package menu.domain.menu;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuCategory {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    ;

    private String name;
    private int num;

    MenuCategory(String name, int num) {
        this.name = this.name();
        this.num = this.ordinal();
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public static MenuCategory fromNum(int num) {
        return BY_NUM.get(num);
    }

    private static final Map<Integer, MenuCategory> BY_NUM =
            Stream.of(values())
                    .collect(
                            Collectors.toMap(
                                    MenuCategory::getNum,
                                    menuCategory -> menuCategory
                            )
                    );
}