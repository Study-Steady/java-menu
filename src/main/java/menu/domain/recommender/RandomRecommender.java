package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.util.RandomGenerator;

public class RandomRecommender implements RandomGenerator {

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }

    @Override
    public String pickFromShuffleList(List<String> shuffleValue) {
        return Randoms.shuffle(shuffleValue).get(0);
    }
}
