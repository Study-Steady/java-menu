package menu.view.input.error;

public enum InputError {

    INPUT_IS_BLANK("입력한 값이 빈 칸 입니다."),
    NOT_POSSIBLE_INPUT("입력할 수 없는 값입니다."),
    COACH_COUNT_NOT_IN_RANGE("코치는 %s명 이상 %s명 이하로 입력해야 합니다. "),
    COACH_NAME_NOT_IN_RANGE("코치 이름은 %s 이상 %s 이하여야 합니다. "),
    NOT_EXIST_MENU("존재하지 않는 메뉴입니다.");;

    final String message;

    InputError(String message) {
        this.message = message;
    }
}