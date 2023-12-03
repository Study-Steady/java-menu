package menu.view.output;

public enum Output {

    INPUT_CAN_NOT_EAT_FOOD("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
    RECOMMEND_RESULT_SUCCESS("\n추천을 완료했습니다.");

    final String message;

    Output(String message) {
        this.message = message;
    }
}