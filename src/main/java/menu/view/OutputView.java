package menu.view;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.MenuCategory;
import menu.model.RecommendedMenuCategories;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    public void printExceptionMessage(String message) {
        println(String.format(EXCEPTION_FORMAT, message));
    }

    private void println(String message) {
        System.out.println(message);
    }

    /**
     * [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ] [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ] [ 포코 | 된장찌개 | 불고기 | 하이라이스
     * | 탕수육 | 나시고렝 ]
     *
     * @param coaches
     * @param menuCategories
     */
    public void printResult(Coaches coaches, RecommendedMenuCategories menuCategories) {
        println("메뉴 추천 결과입니다.");
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printRecommendedMenuCategories(menuCategories);
        printCoachesMenu(coaches);
        printEmptyLine();
        println("추천을 완료했습니다.");
    }

    private void printCoachesMenu(Coaches coaches) {
        coaches.getCoaches().forEach(this::printCoachMenu);
    }

    private void printCoachMenu(Coach coach) {
        String coachName = coach.getName().getName();
        List<String> menuNames = coach.getRecommendMenus().getMenus().stream()
                .map(Menu::getName)
                .toList();

        String formattedMenuNames = String.join(" | ", menuNames);
        println(String.format("[ %s | %s ]", coachName, formattedMenuNames));
    }

    private void printRecommendedMenuCategories(RecommendedMenuCategories menuCategories) {
        List<MenuCategory> recommendedMenuCategories = menuCategories.getMenuCategories();

        List<String> categoryNames = recommendedMenuCategories.stream()
                .map(MenuCategory::getName)
                .toList();

        String formattedCategoryNames = String.join(" | ", categoryNames);
        println(String.format("[ 카테고리 | %s ]", formattedCategoryNames));
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.");
        printEmptyLine();
    }
}
