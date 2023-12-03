package menu.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import menu.domain.Categories;
import menu.domain.CategoriesPicker;
import menu.domain.MenusPicker;
import menu.domain.NumberGenerator;
import menu.domain.PlayerNames;
import menu.domain.Players;
import menu.domain.RandomMenusPicker;
import menu.domain.RandomNumberGenerator;
import menu.domain.WeeklyCategories;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        List<String> rawPlayerNames = readWithRetry(inputView::inputPlayerNames);
        PlayerNames playerNames = readWithRetry(PlayerNames::from, rawPlayerNames);
        Players players = readWithRetry(inputView::inputAvoidedMenu, playerNames);

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Categories categories = new CategoriesPicker(numberGenerator).pick();

        MenusPicker menusPicker = new RandomMenusPicker();
        WeeklyCategories weeklyCategories = WeeklyCategories.of(categories, menusPicker);

        weeklyCategories.recommandMenus(players);

    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(function, input);
        }
    }
}
