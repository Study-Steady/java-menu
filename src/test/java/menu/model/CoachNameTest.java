package menu.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"코치", "김코치님"})
    void 코치이름은_유효한_범위의_길이로_구성할_경우_예외가_발생하지_않는다(String coachName) {
        assertDoesNotThrow(() -> CoachName.from(coachName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"김", "김초니치킴"})
    void 코치이름은_유효한_범위의_길이로_구성하지_않을_경우_예외가_발생한다(String coachName) {
        assertThatThrownBy(() -> CoachName.from(coachName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
