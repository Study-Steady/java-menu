package menu.view.output;

public enum OutputMessage {
    WELCOME("점심 메뉴 추천을 시작합니다."),
    RECOMMEND_MENU("메뉴 추천 결과입니다."),
    FINISH("추천을 완료했습니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
