package menu.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomPicker implements Picker {
    private static final int FIRST_INDEX = 0;

    @Override
    public String pickOne(List<String> values) {
        return Randoms.shuffle(values).get(FIRST_INDEX);
    }
}
