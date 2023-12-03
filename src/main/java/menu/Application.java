package menu;

import menu.controller.Controller;
import menu.view.input.InputView;
import menu.view.output.OutputView;
import menu.view.print.ConsolePrinter;
import menu.view.print.Printer;
import menu.view.read.ConsoleReader;
import menu.view.read.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        Controller controller = new Controller(new InputView(reader, printer), new OutputView(printer));

        controller.run();
    }

}
