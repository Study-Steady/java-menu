package menu;

import menu.controller.MenuRecommendationController;
import menu.view.ErrorView;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        MenuRecommendationController controller = new MenuRecommendationController(initHandler(), outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}
