package menu;

import menu.controller.MenuRecommendController;
import menu.model.NumberGenerator;
import menu.model.Picker;
import menu.model.RandomNumberGenerator;
import menu.model.RandomPicker;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Picker picker = new RandomPicker();
        MenuRecommendController menuRecommendController = new MenuRecommendController(inputView, outputView,
                numberGenerator, picker);
        menuRecommendController.run();
    }
}
