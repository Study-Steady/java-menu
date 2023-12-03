package menu;

import menu.controller.MenuRecommendController;
import menu.domain.menu.MenuCategoryGroup;
import menu.view.input.ConsoleReader;
import menu.view.input.InputView;
import menu.view.input.Reader;
import menu.view.output.ConsolePrinter;
import menu.view.output.OutputView;
import menu.view.output.Printer;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = new InputView(reader, printer);
        OutputView outputView = new OutputView(printer);
        MenuCategoryGroup menuCategoryGroup = MenuCategoryGroup.create();

        MenuRecommendController menuRecommendController = MenuRecommendController.of(inputView, outputView, menuCategoryGroup);
        menuRecommendController.run();
    }
}
