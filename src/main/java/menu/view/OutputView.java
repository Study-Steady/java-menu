package menu.view;

import menu.domain.Players;
import menu.view.printer.Printer;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printStart() {
        printer.printLine("점심 메뉴 추천을 시작합니다.");
        printer.printEmptyLine();
    }


    public void printExceptionMessage(String message) {
        printer.printLine(ERROR_MESSAGE_FORMAT + message);
        printer.printEmptyLine();
    }
}
