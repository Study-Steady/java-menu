package menu;

import menu.controller.MenuRecommendController;
import menu.model.NumberGenerator;
import menu.model.RandomNumberGenerator;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MenuRecommendController menuRecommendController = new MenuRecommendController(inputView, outputView,
                numberGenerator);
        menuRecommendController.run();
    }
}
