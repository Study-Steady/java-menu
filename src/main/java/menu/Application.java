package menu;

import menu.controller.MenuRecommendController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MenuRecommendController menuRecommendController = new MenuRecommendController(inputView, outputView);
        menuRecommendController.run();
    }
}