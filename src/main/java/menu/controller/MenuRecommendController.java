package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.MenuCategory;
import menu.model.NumberGenerator;
import menu.model.Picker;
import menu.model.RecommendedMenuCategories;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final Picker picker;

    public MenuRecommendController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator,
                                   Picker picker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.picker = picker;
    }

    public void run() {
        outputView.printStartMessage();
        Coaches coaches = fetch(this::readCoachNames);
        handleHateMenusOfCoaches(coaches);
        RecommendedMenuCategories menuCategories = MenuCategory.recommendCategory(numberGenerator);
        menuCategories.recommendMenus(coaches, picker);

    }

    private void handleHateMenusOfCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<Menu> hateMenus = fetch(() -> readHateMenus(coach.getName()));
            coach.addHateMenus(hateMenus);
        }
    }

    private List<Menu> readHateMenus(CoachName coachName) {
        List<String> rawHateMenus = inputView.readHateMenu(coachName);
        return rawHateMenus.stream()
                .map(Menu::from)
                .toList();
    }

    private Coaches readCoachNames() {
        List<String> rawCoachNames = inputView.readCoachNames();
        return Coaches.from(rawCoachNames);
    }

    private <T> T fetch(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return fetch(supplier);
        }
    }
}
