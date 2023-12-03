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
        PlayerNames playerNames = readWithRetry(this::getPlayersName);
        Players players = readWithRetry(inputView::inputAvoidedMenu, playerNames); // 여기 수정 필요 한명 잘못받으면 처음부터됨

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Categories categories = new CategoriesPicker(numberGenerator).pick();

        MenusPicker menusPicker = new RandomMenusPicker();
        WeeklyCategories weeklyCategories = WeeklyCategories.of(categories, menusPicker);

        weeklyCategories.recommandMenus(players);

        outputView.printResult(categories, players);
    }

    private PlayerNames getPlayersName() {
        List<String> rawPlayerNames = readWithRetry(inputView::inputPlayerNames);
        return PlayerNames.from(rawPlayerNames);
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
