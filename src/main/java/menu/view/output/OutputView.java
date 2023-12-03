package menu.view.output;

import static menu.view.output.OutputMessage.FINISH;
import static menu.view.output.OutputMessage.RECOMMEND_MENU;
import static menu.view.output.OutputMessage.WELCOME;

public class OutputView {
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printWelcome() {
        printer.printMessage(WELCOME.getMessage());
    }

    public void printResult(String formattedResult) {
        printer.printMessage(RECOMMEND_MENU.getMessage());
        printer.printMessage(formattedResult);
    }

    public void printErrorMessage(Exception e) {
        printer.printMessage(e.getMessage());
    }

    public void printFinish() {
        printer.printMessage(FINISH.getMessage());
    }
}
