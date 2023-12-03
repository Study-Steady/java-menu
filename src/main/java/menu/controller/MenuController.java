package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.PlayerName;
import menu.domain.PlayerNames;
import menu.domain.Players;
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
        PlayerNames playerNames = PlayerNames.from(inputView.inputPlayerNames());
        Players players = inputView.inputAvoidedMenu(playerNames);
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
