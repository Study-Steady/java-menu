package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuCategoryTest {

    /**
     *      public static MenuCategory findCategory(NumberGenerator numberGenerator) {
     *         while (true) {
     *             int randomNumber = numberGenerator.generateBetween(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
     *             if (randomNumber >= MIN_CATEGORY_NUMBER && randomNumber <= MAX_CATEGORY_NUMBER) {
     *                 return findCategoryByNumber(randomNumber);
     *             }
     *         }
     *     }
     *
     *     private static MenuCategory findCategoryByNumber(int categoryNumber) {
     *         return Stream.of(MenuCategory.values())
     *                 .filter(menuCategory -> menuCategory.categoryNumber == categoryNumber)
     *                 .findFirst()
     *                 .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
     *     }
     */
    @Test
    void 유요한_범위의_번호가_나올때까지_반복하며_번호에_맞는_카테고리를_찾아낸다() {
        NumberGenerator numberGenerator = new NumberGenerator() {
            private Queue<Integer> queue = new LinkedList<>(List.of(0, 6, 2));

            @Override
            public int generateBetween(int min, int max) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return queue.poll();
            }
        };

        MenuCategory menuCategory = MenuCategory.findCategory(numberGenerator);

        assertEquals(MenuCategory.KOREAN, menuCategory);
    }

    @ParameterizedTest
    @MethodSource("provideValidCategoryNumbers")
    void 유효한_범위의_숫자에_맞는_메뉴_카테고리를_찾을_수_있다(int randomNumber, MenuCategory expected) {
        MenuCategory menuCategory = MenuCategory.findCategory((min, max) -> randomNumber);

        assertThat(menuCategory).isEqualTo(expected);
    }

    @Test
    void recommendMenusTo() {
        Coaches coaches = Coaches.from(List.of("김코치", "이코치"));
        Picker picker = (menuNames) -> "김치찌개";
        Coaches expectedCoaches = new Coaches(
                List.of(new Coach(CoachName.from("김코치"), HateMenus.defaultOf(),
                                new RecommendMenus(List.of(Menu.KIMCHI_JJIGAE))),
                        new Coach(CoachName.from("이코치"), HateMenus.defaultOf(),
                                new RecommendMenus(List.of(Menu.KIMCHI_JJIGAE)))));

        MenuCategory.KOREAN.recommendMenusTo(coaches, picker);

        assertThat(coaches).usingRecursiveComparison()
                .isEqualTo(expectedCoaches);
    }

    private static Stream<Arguments> provideValidCategoryNumbers() {
        return Stream.of(
                Arguments.of(1, MenuCategory.JAPANESE),
                Arguments.of(2, MenuCategory.KOREAN),
                Arguments.of(3, MenuCategory.CHINESE),
                Arguments.of(4, MenuCategory.ASIAN),
                Arguments.of(5, MenuCategory.WESTERN)
        );
    }
}
