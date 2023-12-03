package menu.view.output;

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

}
