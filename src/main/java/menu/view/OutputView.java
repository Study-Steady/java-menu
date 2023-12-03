package menu.view;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    public void printExceptionMessage(String message) {
        println(String.format(EXCEPTION_FORMAT, message));
    }

    private void println(String message) {
        System.out.println(message);
    }

    public void printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.");
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
