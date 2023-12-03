package menu.domain.recommend.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SystemRandomMenuNamePicker implements RandomMenuNamePicker {

    @Override
    public String pick(List<String> menuNames) {
        return Randoms.shuffle(menuNames).get(0);
    }

}
