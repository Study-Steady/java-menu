package menu.util.validator;

import java.util.Arrays;
import java.util.List;
import menu.util.constant.MenuConstant;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public class CoachValidator {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;

    public List<String> validate(String coache) {
        validateNotBlank(coache);
        List<String> coaches = divideToList(coache);
        validateAllInRangeName(coaches);
        validateCoachCount(coaches);
        return coaches;
    }

    private void validateNotBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new InputIllegalArgumentException(InputError.INPUT_IS_BLANK);
        }
    }

    private List<String> divideToList(String inputValue) {
        return Arrays.stream(inputValue.split(MenuConstant.SPLIT_SYMBOL))
                .map(String::trim)
                .toList();
    }

    private boolean hasOverLengthName(List<String> inputValue) {
        return inputValue.stream()
                .anyMatch(input -> isNotInRangeName(input.length()));
    }

    private void validateAllInRangeName(List<String> inputValue) {
        if (hasOverLengthName(inputValue)) {
            throw new InputIllegalArgumentException(InputError.COACH_NAME_NOT_IN_RANGE, MIN_COACH_COUNT,
                    MAX_COACH_COUNT);
        }
    }

    private void validateCoachCount(List<String> inputValue) {
        if (isNotInRangeCoachCount(inputValue.size())) {
            throw new InputIllegalArgumentException(InputError.COACH_COUNT_NOT_IN_RANGE, MIN_NAME_LENGTH,
                    MAX_NAME_LENGTH);
        }
    }

    private boolean isNotInRangeName(int number) {
        return number < MIN_NAME_LENGTH || number > MAX_NAME_LENGTH;
    }

    private boolean isNotInRangeCoachCount(int number) {
        return number < MIN_COACH_COUNT || number > MAX_COACH_COUNT;
    }
}
