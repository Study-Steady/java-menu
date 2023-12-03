package menu.view.input;

public enum InputGuideMessage {

    COACH_NAME_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    RESTRICTED_MENU_INPUT("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

