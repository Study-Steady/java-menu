package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachManager;
import menu.domain.coach.CoachName;
import menu.domain.coach.MenuBlackList;
import menu.domain.menu.MenuCategory;
import menu.domain.menu.MenuCategoryGroup;
import menu.utils.OutputFormatter;
import menu.view.input.InputView;
import menu.view.output.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuCategoryGroup menuCategoryGroup;
    private CoachManager coachManager;

    private MenuRecommendController(InputView inputView, OutputView outputView, MenuCategoryGroup menuCategoryGroup) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuCategoryGroup = menuCategoryGroup;
    }

    public static MenuRecommendController of(InputView inputView, OutputView outputView, MenuCategoryGroup menuCategoryGroup) {
        return new MenuRecommendController(inputView, outputView, menuCategoryGroup);
    }

    public void run() {
        outputView.printWelcome();
        coachManager = setUpCoachManager();
        recommendMenu();
        outputView.printResult(OutputFormatter.format(menuCategoryGroup, coachManager));
        outputView.printFinish();
    }

    private CoachManager setUpCoachManager() {
        List<CoachName> coachNames = getCoachNames();
        List<MenuBlackList> rawBlackLists = new ArrayList<>();
        for (CoachName coachName : coachNames) {
            rawBlackLists.add(getBlackList(coachName.getName()));
        }
        return CoachManager.from(setUpCoaches(coachNames, rawBlackLists));
    }

    private List<CoachName> getCoachNames() {
        return inputWithRetry(inputView::getCoachManager);
    }

    private MenuBlackList getBlackList(String coachName) {
        return inputWithRetry(() -> inputView.getBlackList(coachName));
    }

    private List<Coach> setUpCoaches(List<CoachName> names, List<MenuBlackList> blackLists) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            coaches.add(Coach.of(names.get(i), blackLists.get(i)));
        }

        return coaches;
    }

    private void recommendMenu() {
        for (MenuCategory category: menuCategoryGroup.getMenuCategoryGroup()) {
            coachManager.addMenusEachFromMenuCategory(category);
        }
    }

    private <T> T inputWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputWithRetry(supplier);
        }
    }
}
