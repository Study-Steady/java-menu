package menu.mock;


import menu.view.print.Printer;

public class FakePrinter implements Printer {

    @Override
    public void printLine(String message) {
    }

    @Override
    public void printWithEmptyLineAhead(String message) {
    }

    @Override
    public void printEmptyLine() {
    }

}
