package menu.view.output;

import menu.domain.coach.Coach;
import menu.domain.recommend.MenuRecommendResult;
import menu.view.print.Printer;

public class OutputView {

    private static final String WELCOME_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void welcomePlayer() {
        printer.printLine(WELCOME_MESSAGE);
    }

    public void showErrorMessage(String message) {
        printer.printLine(ErrorMessageFormatter.addErrorPrefix(message));
    }

    public void showMenuRecommendResult(MenuRecommendResult menuRecommendResult) {
        printer.printWithEmptyLineAhead("메뉴 추천 결과입니다.");
        printer.printLine("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printer.printLine(OutputFormatter.toCategoryFormat(menuRecommendResult.getMenuCategories()));

        for (Coach coach : menuRecommendResult.getCoaches().getCoaches()) {
            printer.printLine(OutputFormatter.toMenuRecommendFormat(coach));
        }

        printer.printWithEmptyLineAhead("추천을 완료했습니다.");
    }

}
