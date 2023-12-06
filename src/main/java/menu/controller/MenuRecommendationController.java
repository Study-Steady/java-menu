package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.InedibleMenus;
import menu.domain.MenuRecommender;
import menu.util.StringConvertor;
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
        String inputCoachNames = participateCoach();

        String[] splitedCoachNames = StringConvertor.splitByComma(inputCoachNames);
        List<Coach> coachNames = new ArrayList<>();
        for (int i = 0; i < splitedCoachNames.length; i++) {
            outputView.printMenuMessageBy(splitedCoachNames[i]);
            String inedibleMenus = inputHandler.receiveValidatedInedibleMenus();
            coachNames.add(new Coach(splitedCoachNames[i], InedibleMenus.from(inedibleMenus)));
            outputView.printNewLine();
        }
        Coaches coaches = new Coaches(coachNames);
        Category category = setUpCategory();
        recommendMenusForEachCategory(coaches, category);
        showMenuRecommendationResults(coaches, category);
    }

    private String participateCoach() {
        outputView.printStartMessage();
        outputView.printCoachNameInputMessage();
        String inputCoachNames = inputHandler.receiveValidatedCoachNames();
        outputView.printNewLine();
        return inputCoachNames;
    }

    private void showMenuRecommendationResults(Coaches coaches, Category category) {
        outputView.printMenuRecommendationResults(coaches, category);
        outputView.printNewLine();
        outputView.printEndMessage();
    }

    private Category setUpCategory() {
        return new Category(MenuRecommender.recommendCategories());
    }

    private void recommendMenusForEachCategory(Coaches coaches, Category category) {
        for (int cat = 0; cat < category.getSize(); cat++) {
            for (int coach = 0; coach < coaches.getCoachCount(); coach++) {
                String menuName = MenuRecommender.recommendMenu(coaches.getCoachBy(coach), category.getCategoryBy(cat));
                coaches.getCoachBy(coach).recommended(menuName);
            }
        }
    }
}
