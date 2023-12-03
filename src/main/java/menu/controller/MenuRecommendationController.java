package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.InedibleMenus;
import menu.domain.Menu;
import menu.domain.MenuRecommander;
import menu.domain.RecommandMenu;
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
        outputView.printStartMessage();
        outputView.printCocheNameInputMessage();
        String inputCoachNames = inputHandler.receiveValidatedCoachNames();
        outputView.printNewLine();

        String[] splitedCoachNames = StringConvertor.splitByComma(inputCoachNames);
        List<Coach> coachNames = new ArrayList<>();
        for (int i = 0; i < splitedCoachNames.length; i++) {
            outputView.printMenuMessageBy(splitedCoachNames[i]);
            String inedibleMenus = inputHandler.receiveValidatedInedibleMenus();
            coachNames.add(new Coach(splitedCoachNames[i], InedibleMenus.from(inedibleMenus)));
            outputView.printNewLine();
        }
        Coaches coaches = new Coaches(coachNames);

        List<RecommandMenu> recommandMenus = new ArrayList<>();
        List<Menu> categories = MenuRecommander.recommandCategories();
        for (int i = 0; i < coaches.getCoachCount(); i++) {
            recommandMenus.add(RecommandMenu.from(coaches.getCoachBy(i), categories));
        }
        outputView.printMenuRecommendationResults(coaches, categories, recommandMenus);
        outputView.printNewLine();
        outputView.printEndMessage();
    }
}
