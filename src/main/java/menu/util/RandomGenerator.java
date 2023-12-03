package menu.util;

import java.util.List;

public interface RandomGenerator {

    int pickNumber();

    String pickFromShuffleList(List<String> shuffleValue);
}
