package menu.controller;

import menu.domain.Category;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class MenuRecommendationController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public MenuRecommendationController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        Coaches coaches = participateCoaches();
        updateInedibleMenus(coaches);
        Category category = setUpCategory();
        recommendMenusForEachCategory(coaches, category);
        showMenuRecommendationResults(coaches, category);
    }

    private Coaches participateCoaches() {
        outputView.printStartMessage();
        outputView.printCoachNameInputMessage();
        String inputCoachNames = inputHandler.receiveValidatedCoachNames();
        outputView.printNewLine();
        return Coaches.from(inputCoachNames);
    }

    private void updateInedibleMenus(Coaches coaches) {
        for (int coach = 0; coach < coaches.getCoachCount(); coach++) {
            outputView.printMenuMessageBy(coaches.getCoachNameBy(coach));
            String inedibleMenus = inputHandler.receiveValidatedInedibleMenus();
            coaches.updateInedibleMenusBy(coach, inedibleMenus);
            outputView.printNewLine();
        }
    }

    private void showMenuRecommendationResults(Coaches coaches, Category category) {
        outputView.printMenuRecommendationResults(coaches, category);
        outputView.printNewLine();
        outputView.printEndMessage();
    }

    private Category setUpCategory() {
        return MenuRecommender.recommendCategories();
    }

    private void recommendMenusForEachCategory(Coaches coaches, Category category) {
        for (int cat = 0; cat < category.getSize(); cat++) {
            for (int coach = 0; coach < coaches.getCoachCount(); coach++) {
                String menuName = MenuRecommender.recommendMenu(coaches.getCoachBy(coach), category.getCategoryBy(cat));
                coaches.recommendBy(coach, menuName);
            }
        }
    }
}
