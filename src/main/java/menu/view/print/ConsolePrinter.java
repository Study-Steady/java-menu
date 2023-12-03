package menu.view.print;

public class ConsolePrinter implements Printer {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printWithEmptyLineAhead(String message) {
        printEmptyLine();
        printLine(message);
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }

}
