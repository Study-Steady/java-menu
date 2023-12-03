package menu.exception;

import static menu.domain.coach.CoachConstant.MAX_COACH_NAME_LENGTH;
import static menu.domain.coach.CoachConstant.MAX_COACH_NUM;
import static menu.domain.coach.CoachConstant.MIN_COACH_NAME_LENGTH;
import static menu.domain.coach.CoachConstant.MIN_COACH_NUM;
import static menu.domain.menu.MenuConstant.MAX_MENU_BLACK_LIST_SIZE;

public enum ExceptionMessage {
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_COACH_NUM(String.format("코치는 %d명 이상 %d명 이하로 입력해 주세요.", MIN_COACH_NUM.getNum(), MAX_COACH_NUM.getNum())),
    INVALID_COACH_NAME_LENGTH(String.format("코치의 이름은 %d글자 이상 %d글자 이하로 입력해 주세요.", MIN_COACH_NAME_LENGTH.getNum(),
        MAX_COACH_NAME_LENGTH.getNum())),
    INVALID_MENU_BLACK_LIST_SIZE(String.format("먹기 싫은 메뉴의 최대 개수는 %d개 입니다.", MAX_MENU_BLACK_LIST_SIZE.getNum())),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ExceptionSymbol.PREFIX.getSymbol() + message;
    }
}
