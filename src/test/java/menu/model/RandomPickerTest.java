package menu.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomPickerTest {

    @Test
    void pickOne() {
        RandomPicker randomPicker = new RandomPicker();
        String actual = randomPicker.pickOne(List.of("김밥", "쌈밥", "떡볶이"));

        assertTrue(List.of("김밥", "쌈밥", "떡볶이").contains(actual));
    }
}
