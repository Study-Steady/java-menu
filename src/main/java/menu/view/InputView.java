package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.StringConvertor;
import menu.view.validation.InputValidator;

public class InputView {

    public String inputCoaches() {
        String input = Console.readLine();
        String trimedInput = StringConvertor.convertTrimedString(input);
        InputValidator.validateSeparator(trimedInput);
        return trimedInput;
    }
}

