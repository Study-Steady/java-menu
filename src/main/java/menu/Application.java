package menu;

import menu.controller.MenuRecommendationController;
import menu.domain.MenuRecommander;
import menu.view.ErrorView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;
import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        OutputView outputView = new OutputView();
        InputHandler inputHandler = new InputHandler(inputView, errorView);

        MenuRecommendationController controller = new MenuRecommendationController(inputHandler, outputView);
        controller.start();
    }
}
