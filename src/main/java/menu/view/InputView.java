package menu.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import menu.model.CoachName;
import menu.view.validator.BlankValidator;
import menu.view.validator.CoachNamesValidator;
import menu.view.validator.HateMenuValidator;

public class InputView {

    public List<String> readCoachNames() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String rawCoachNames = readLine();
        printEmptyLine();
        validateCoachNames(rawCoachNames);
        return split(",", rawCoachNames);
    }

    private void validateCoachNames(String rawCoachNames) {
        BlankValidator.validate(rawCoachNames);
        CoachNamesValidator.validate(rawCoachNames);

    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public List<String> readHateMenu(CoachName coachName) {
        println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName.getName()));
        String rawHateMenu = readLine();
        printEmptyLine();
        validateHateMenu(rawHateMenu);
        return split(",", rawHateMenu);
    }

    private void validateHateMenu(String rawHateMenu) {
        HateMenuValidator.validate(rawHateMenu);
    }

}
