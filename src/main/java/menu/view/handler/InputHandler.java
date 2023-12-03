package menu.view.handler;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.CoachesFactory;
import menu.util.StringConvertor;
import menu.view.ErrorView;
import menu.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public Coaches createValidatedCoaches() {
        return receiveValidatedInput(() -> {
            String inputCoaches = inputView.inputCoaches();
            return CoachesFactory.createCoachesBy(inputCoaches);
        });
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
