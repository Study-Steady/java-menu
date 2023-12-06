package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coaches;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printCoachNameInputMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printMenuMessageBy(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printMenuRecommendationResults(Coaches coaches, Category category) {
        StringBuilder result = new StringBuilder();
        result.append("메뉴 추천 결과입니다.\n")
                .append("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n")
                .append("[ 카테고리 | ")
                .append(String.join(" | ", category.getCategoryNames()))
                .append(" ]\n");
        for (int coach = 0; coach < coaches.getCoachCount(); coach++) {
            List<String> recommendMenus = coaches.getRecommendMenusBy(coach);
            result.append(String.format("[ %s | ", coaches.getCoachNameBy(coach)))
                    .append(String.join(" | ", recommendMenus))
                    .append(" ]\n");
        }
        System.out.print(result);
    }

    public void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
