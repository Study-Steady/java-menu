package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.RecommandMenu;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printCocheNameInputMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printMenuMessageBy(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printMenuRecommendationResults(Coaches coaches, List<Menu> categories, List<RecommandMenu> recommandMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]\n", categories.get(0).getCategoryName(), categories.get(1).getCategoryName(), categories.get(2).getCategoryName(), categories.get(3).getCategoryName(), categories.get(4).getCategoryName());
        for (int i = 0; i < coaches.getCoachCount(); i++) {
            System.out.printf("[ %s", coaches.getCoachBy(i).getName());
            for (int j = 0; j < recommandMenus.size(); j++) {
                System.out.printf(" | %s", recommandMenus.get(j));
            }
            System.out.println(" ]");
        }
    }

    public void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
