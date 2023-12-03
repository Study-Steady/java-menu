package menu.view;

import java.util.List;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;
import menu.view.validator.BlankValidator;
import menu.view.validator.CoachNamesValidator;

public class InputView {

    public List<String> readCoachNames() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String rawCoachNames = readLine();
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

    private void print(String message) {
        System.out.print(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }
}
