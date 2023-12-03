package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameTest {

    @DisplayName("코치의 이름은 1글자 또는 5글자 이상이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "오", "다람쥐호랑"})
    void invalid_name_cant_create_instance(String name) {
        assertThatThrownBy(() -> CoachName.from(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치의 이름은 2글자 사이면 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"포비", "크롱", "뽀로로", "다람쥐", "김나박이"})
    void coachName_length_in_range(String name) {
        CoachName coachName = CoachName.from(name);
    }
}