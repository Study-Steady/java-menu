package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.StringConvertor;
import menu.view.validation.CoachNameValidator;
import menu.view.validation.InedibleMenuValidator;

public class InputView {

    public String inputCoaches() {
        String input = Console.readLine();
        String trimedInput = StringConvertor.convertTrimedString(input);
        CoachNameValidator.validate(trimedInput);
        return trimedInput;
    }

    public String inputInedibleMenus() {
        String input = Console.readLine();
        InedibleMenuValidator.validate(input);
        return input;
    }
}

