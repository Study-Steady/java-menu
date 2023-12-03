package menu.domain.menu;

import java.util.Arrays;

public enum MenuCategory {

    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String description;
    private final int menuNo;

    MenuCategory(String description, int menuNo) {
        this.description = description;
        this.menuNo = menuNo;
    }

    public static MenuCategory getByMenuNo(int menuNo) {
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.matchesMenuNo(menuNo))
                .findFirst()
                .orElseThrow();
    }

    private boolean matchesMenuNo(int menuNo) {
        return this.menuNo == menuNo;
    }

    public String getDescription() {
        return description;
    }

    public int getMenuNo() {
        return menuNo;
    }

}
