package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.Coaches;
import menu.model.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Coaches coaches = fetch(this::readCoachNames);
        handleHateMenusOfCoaches(coaches);
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
