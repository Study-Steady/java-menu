package menu;

import menu.controller.MenuController;
import menu.view.input.InputView;
import menu.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new MenuController(inputView, outputView).run();
    }
}