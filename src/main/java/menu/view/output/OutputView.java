package menu.view.output;

import java.util.List;
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

    public void showMenuRecommendResult(List<MenuRecommendResult> recommend) {
        printer.printWithEmptyLineAhead("메뉴 추천 결과입니다.");
        printer.printLine("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        for (MenuRecommendResult menuRecommendResult : recommend) {
            printer.printLine(OutputFormatter.toMenuRecommendFormat(menuRecommendResult));
        }

        printer.printLine("추천을 완료했습니다.");
    }

}
