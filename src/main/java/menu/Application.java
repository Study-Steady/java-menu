package menu;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.printer.ConsolePrinter;
import menu.view.printer.Printer;
import menu.view.reader.ConsoleReader;
import menu.view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        MenuController menuController = new MenuController(inputView, outputView);
        menuController.run();
    }
}
