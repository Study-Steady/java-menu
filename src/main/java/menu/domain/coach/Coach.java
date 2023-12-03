package menu.domain.coach;

import menu.domain.menu.Menu;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private final RestrictedMenu restrictedMenu;

    private Coach(String name, RestrictedMenu restrictedMenu) {
        this.name = name;
        this.restrictedMenu = restrictedMenu;
    }

    public static Coach of(String name, RestrictedMenu restrictedMenu) {
        validateNameLength(name);
        return new Coach(name, restrictedMenu);
    }

    private static void validateNameLength(String name) {
        if (!meetsNameLengthCriterion(name)) {
            throw new IllegalArgumentException("이름 길이 조건이 맞지 않습니다.");
        }
    }

    private static boolean meetsNameLengthCriterion(String name) {
        return name.length() >= MAX_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public boolean canEat(Menu menu) {
        return this.restrictedMenu.contains(menu);
    }

}
