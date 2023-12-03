package menu.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public enum MenuType {

    JAPANESE("일식", 1),

    KOREAN("한식", 2),

    CHINESE("중식", 3),

    ASIAN("아시안", 4),

    WESTERN("양식", 5);

    final String name;
    final int typeCount;

    MenuType(String name, int typeCount) {
        this.name = name;
        this.typeCount = typeCount;
    }

    public static MenuType getMenuType(int number) {
        return Arrays.stream(values())
                .filter(menu -> menu.typeCount == number)
                .findFirst()
                .orElseThrow(() -> new InputIllegalArgumentException(InputError.NOT_EXIST_MENU));
    }

    public static List<String> convertToNameList(List<MenuType> menuTypes) {
        return menuTypes.stream()
                .map(menuType -> menuType.name)
                .collect(Collectors.toList());
    }
}
