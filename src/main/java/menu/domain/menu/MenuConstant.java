package menu.domain.menu;

public enum MenuConstant {
    MAX_MENU_BLACK_LIST_SIZE(2),
    ;

    private final int num;

    MenuConstant(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
