package menu.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void generateBetween() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int actual = randomNumberGenerator.generateBetween(1, 5);

        assertAll(
                () -> assertTrue(actual >= 1),
                () -> assertTrue(actual <= 5)
        );
    }
}
