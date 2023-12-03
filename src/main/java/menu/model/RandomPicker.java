package menu.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomPicker implements Picker {
    @Override
    public String pickOne(List<String> values) {
        return Randoms.shuffle(values).get(0);
    }
}
