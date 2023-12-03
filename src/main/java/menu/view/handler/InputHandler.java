package menu.view.handler;

import java.util.function.Supplier;
import menu.view.ErrorView;
import menu.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public String receiveValidatedCoachNames() {
        return receiveValidatedInput(inputView::inputCoaches);
    }

    public String receiveValidatedInedibleMenus() {
        return receiveValidatedInput(inputView::inputInedibleMenus);
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
