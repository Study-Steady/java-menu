package menu.view.input;

import static menu.domain.coach.CoachConstant.MIN_COACH_NUM;
import static menu.exception.ExceptionMessage.INVALID_COACH_NUM;
import static menu.exception.ExceptionMessage.INVALID_INPUT;
import static menu.utils.StringUtils.convertStringToCoachNames;
import static menu.utils.StringUtils.splitStringByDelimeterAndConvertToSet;
import static menu.view.input.InputMessage.INPUT_BLACKLIST_MENU;
import static menu.view.input.InputMessage.INPUT_COACH_NAME;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import menu.domain.coach.CoachConstant;
import menu.domain.coach.CoachName;
import menu.domain.menu.MenuBlackList;
import menu.view.output.Printer;

public class InputView {
    private final Reader reader;
    private final Printer printer;

    public InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }
    public List<CoachName> getCoachManager() {
        printer.printMessage(INPUT_COACH_NAME.getMessage());
        String input = reader.readLine();
        validateInput(input);
        List<CoachName> coachNames = convertStringToCoachNames(input);
        validateCoachNum(coachNames);
        return coachNames;
    }

    public MenuBlackList getBlackList(String coachName) {
        printer.printMessage(coachName + INPUT_BLACKLIST_MENU.getMessage());
        String input = reader.readLine();
        Set<String> rawBlackList = splitStringByDelimeterAndConvertToSet(input);
        return MenuBlackList.from(rawBlackList);
    }

    private static void validateInput(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateCoachNum(List<CoachName> coachNames) {
        if (coachNames.size() < MIN_COACH_NUM.getNum() || coachNames.size() > CoachConstant.MAX_COACH_NUM.getNum()) {
            throw new IllegalArgumentException(INVALID_COACH_NUM.getMessage());
        }
    }
}
