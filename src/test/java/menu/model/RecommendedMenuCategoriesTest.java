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

class RecommendedMenuCategoriesTest {
    @Test
    void 추천된_메뉴_카테고리_목록에서_카테고리_중복횟수가_유효한_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new RecommendedMenuCategories(
                List.of(MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.JAPANESE,
                        MenuCategory.ASIAN)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추천된_메뉴_카테고리_목록에서_유효한_중복횟수에_벗어나지_않으면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> new RecommendedMenuCategories(
                List.of(MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.JAPANESE,
                        MenuCategory.ASIAN,
                        MenuCategory.WESTERN)));
    }

    @Test
    void 추천된_카테고리_개수는_유효한_개수_범위안에서_생성되면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> new RecommendedMenuCategories(
                List.of(MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.JAPANESE,
                        MenuCategory.ASIAN,
                        MenuCategory.WESTERN)));
    }

    @Test
    void 추천된_카테고리_개수는_유효한_개수_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new RecommendedMenuCategories(
                List.of(MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.JAPANESE,
                        MenuCategory.ASIAN,
                        MenuCategory.WESTERN)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbers")
    void 추천된_카테고리를_랜덤하게_생성되는_숫자로부터_생성할_수_있다(List<Integer> randomNumbers, List<MenuCategory> expected) {
        NumberGenerator numberGenerator = new NumberGenerator() {
            private Queue<Integer> queue = new LinkedList<>(randomNumbers);

            @Override
            public int generateBetween(int min, int max) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return queue.poll();
            }
        };

        RecommendedMenuCategories recommendedMenuCategories = RecommendedMenuCategories.create(numberGenerator);

        assertThat(recommendedMenuCategories.getMenuCategories()).isEqualTo(expected);
    }

    /**
     *      public void recommendMenus(Coaches coaches, Picker picker) {
     *         for (MenuCategory menuCategory : menuCategories) {
     *             menuCategory.recommendMenusTo(coaches, picker);
     *         }
     *     }
     */
    @Test
    void recommendMenus() {
        Coaches coaches = Coaches.from(List.of("김코치", "이코치"));
        Picker picker = new Picker() {
            private Queue<String> queue = new LinkedList<>(List.of(
                    "김치찌개", "김치찌개",
                    "김밥", "김밥",
                    "규동", "규동",
                    "월남쌈", "월남쌈",
                    "나시고렝", "나시고렝"));

            @Override
            public String pickOne(List<String> values) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return queue.poll();

            }
        };
        Coaches expectedCoaches = new Coaches(
                List.of(new Coach(CoachName.from("김코치"), HateMenus.defaultOf(),
                                new RecommendMenus(List.of(
                                        Menu.KIMCHI_JJIGAE,
                                        Menu.GIMBAP,
                                        Menu.GYUDON,
                                        Menu.WOL_NAM_SAM,
                                        Menu.NASI_GORENG))),
                        new Coach(CoachName.from("이코치"), HateMenus.defaultOf(),
                                new RecommendMenus(List.of(
                                        Menu.KIMCHI_JJIGAE,
                                        Menu.GIMBAP,
                                        Menu.GYUDON,
                                        Menu.WOL_NAM_SAM,
                                        Menu.NASI_GORENG)))));

        RecommendedMenuCategories recommendedMenuCategories = new RecommendedMenuCategories(
                List.of(MenuCategory.KOREAN,
                        MenuCategory.KOREAN,
                        MenuCategory.JAPANESE,
                        MenuCategory.ASIAN,
                        MenuCategory.ASIAN));

        recommendedMenuCategories.recommendMenus(coaches, picker);

        assertThat(coaches).usingRecursiveComparison()
                .isEqualTo(expectedCoaches);
    }

    private static Stream<Arguments> provideRandomNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 6, 1, 2, 3, 4, 5), List.of(MenuCategory.JAPANESE,
                        MenuCategory.KOREAN,
                        MenuCategory.CHINESE,
                        MenuCategory.ASIAN,
                        MenuCategory.WESTERN)),
                Arguments.of(List.of(0, 6, 1, 1, 1, 2, 3, 4), List.of(MenuCategory.JAPANESE,
                        MenuCategory.JAPANESE,
                        MenuCategory.KOREAN,
                        MenuCategory.CHINESE,
                        MenuCategory.ASIAN))
        );
    }
}
