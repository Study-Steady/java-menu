package menu.util.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.util.constant.MenuConstant;
import menu.view.input.error.InputError;
import menu.view.input.error.InputIllegalArgumentException;

public class HateFoodValidator {

    private static final int MAX_HATE_FOOD_COUNT = 2;

    public List<String> validate(String inputValue) {
        List<String> hateFoods = divideToList(inputValue);
        validateOverMaxFoodCount(hateFoods);
        return hateFoods;
    }

    private List<String> divideToList(String inputValue) {
        if (inputValue.isBlank()) {
            return new ArrayList<>();
        }

        return Arrays.stream(inputValue.split(MenuConstant.SPLIT_SYMBOL))
                .map(String::trim)
                .toList();
    }

    private void validateOverMaxFoodCount(List<String> hateFoods) {
        if (hateFoods.size() > MAX_HATE_FOOD_COUNT) {
            throw new InputIllegalArgumentException(InputError.NOT_POSSIBLE_INPUT);
        }
    }

}
