package menu.view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.domain.coach.Coaches;
import menu.utils.StringConvertor;
import menu.utils.StringValidator;
import menu.view.print.Printer;
import menu.view.read.Reader;

public class InputView {

    private final Reader reader;
    private final Printer printer;

    public InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public List<String> inputCoachNames() {
        printer.printWithEmptyLineAhead(InputGuideMessage.COACH_NAME_INPUT.getMessage());
        String rawInput = reader.readLine();

        StringValidator.validateHasText(rawInput);

        List<String> coachNames = StringConvertor.splitByComma(rawInput);
        validateCoachSize(coachNames);

        return coachNames;
    }

    public List<String> inputRestrictedMenu(String coachName) {
        printer.printWithEmptyLineAhead(coachName + InputGuideMessage.RESTRICTED_MENU_INPUT.getMessage());
        String rawInput = reader.readLine();

        StringValidator.validateHasText(rawInput);

        return StringConvertor.splitByComma(rawInput);
    }

    private void validateCoachSize(List<String> coachNames) {
        if (!meetsCoachSizeCriterion(coachNames)) {
            throw new IllegalArgumentException("식사를 함께하기 위한 코치 인원수 조건이 맞지 않습니다.");
        }
    }

    private boolean meetsCoachSizeCriterion(List<String> coachNames) {
        if (Objects.isNull(coachNames) || coachNames.isEmpty()) {
            return false;
        }
        return coachNames.size() >= Coaches.MIN_COACH_SIZE
                && coachNames.size() <= Coaches.MAX_COACH_SIZE;
    }

}
