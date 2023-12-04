package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoachesTest {

    @ParameterizedTest
    @MethodSource("provideValidCoachNames")
    void 코치는_최소_2명_최대_5명까지_식사를_함께한다(List<String> coachNames) {
        assertDoesNotThrow(() -> Coaches.from(coachNames));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCoachNames")
    void 코치는_유효한_범위안의_인원들로_구성되어_있지_않다면_예외가_발생한다(List<String> coachNames) {
        assertThatThrownBy(() -> Coaches.from(coachNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     *      public void recommendMenus(List<String> menuNames, Picker picker) {
     *         for (Coach coach : coaches) {
     *             coach.recommendedMenu(menuNames, picker);
     *         }
     *     }
     */
    @Test
    void recommendMenus() {
        Coaches coaches = Coaches.from(List.of("김코치", "이코치"));
        Picker picker = new Picker() {
            private Queue<String> menuNames = new LinkedList<>(List.of("된장찌개", "김치찌개"));

            @Override
            public String pickOne(List<String> values) {
                if (menuNames.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return menuNames.poll();
            }
        };

        coaches.recommendMenus(List.of("김밥", "월남쌈", "김치찌개"), picker);

        Coaches expectedCoaches = new Coaches(List.of(
                new Coach(CoachName.from("김코치"), HateMenus.defaultOf(),
                        new RecommendMenus(List.of(Menu.DOENJANG_JJIGAE))),
                new Coach(CoachName.from("이코치"), HateMenus.defaultOf(),
                        new RecommendMenus(List.of(Menu.KIMCHI_JJIGAE)))
        ));

        assertThat(coaches).usingRecursiveComparison().isEqualTo(expectedCoaches);
    }

    private static Stream<Arguments> provideInvalidCoachNames() {
        return Stream.of(
                Arguments.of(List.of("김코치")),
                Arguments.of(List.of("김코치", "이코치", "박코치", "성코치", "정코치", "최코치"))
        );
    }

    private static Stream<List<String>> provideValidCoachNames() {
        return Stream.of(
                List.of("김코치", "이코치"),
                List.of("김코치", "이코치", "박코치", "성코치", "정코치")
        );
    }
}
