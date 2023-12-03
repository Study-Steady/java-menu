package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
class MenuCategoryTest {

    @ParameterizedTest
    @MethodSource("provideRandomCategoryNumbers")
    void 유효하지_않은_카테고리_넘버가_생성되어도_재시도를_통해_유효한_카테고리_넘버를_생성한다(List<Integer> categoryNumbers) {
        NumberGenerator numberGenerator = createNumberGenerator(categoryNumbers);

        RecommendedMenuCategories menuCategory = MenuCategory.recommendCategory(numberGenerator);

        assertThat(menuCategory.getMenuCategories()).containsExactly(
                MenuCategory.JAPANESE,
                MenuCategory.KOREAN,
                MenuCategory.CHINESE,
                MenuCategory.ASIAN,
                MenuCategory.WESTERN
        );
    }

    private static NumberGenerator createNumberGenerator(List<Integer> randomNumbers) {
        NumberGenerator numberGenerator = new NumberGenerator() {

            private final List<Integer> numbers = new LinkedList<>(randomNumbers);

            @Override
            public int generateBetween(int min, int max) {
                if (numbers.isEmpty()) {
                    throw new NoSuchElementException("더 이상 번호가 없습니다.");
                }

                return numbers.remove(0);
            }
        };
        return numberGenerator;
    }

    @ParameterizedTest
    @MethodSource("provideRandomCategoryNumbersForOverFrequency")
    void 추천된_카테고리가_3번_이상_반복되어_추천되는_경우_재시도를_통해_새롭게_추천한다(List<Integer> overFrequencyCategoryNumbers,
                                                       List<Integer> newCategoryNumbers) {
        overFrequencyCategoryNumbers.addAll(newCategoryNumbers);
        NumberGenerator numberGenerator = createNumberGenerator(overFrequencyCategoryNumbers);

        RecommendedMenuCategories menuCategory = MenuCategory.recommendCategory(numberGenerator);

        assertThat(menuCategory.getMenuCategories()).containsExactly(
                MenuCategory.JAPANESE,
                MenuCategory.KOREAN,
                MenuCategory.CHINESE,
                MenuCategory.ASIAN,
                MenuCategory.WESTERN
        );
    }

    @Test
    void 최대_중복가능한_유효한_카테고리_넘버들로_이루어진_숫자목록으로는_정상적으로_메뉴추천이_가능하다() {
        NumberGenerator numberGenerator = createNumberGenerator(List.of(1, 1, 2, 2, 3));

        RecommendedMenuCategories menuCategory = MenuCategory.recommendCategory(numberGenerator);

        assertThat(menuCategory.getMenuCategories()).containsExactly(
                MenuCategory.JAPANESE,
                MenuCategory.JAPANESE,
                MenuCategory.KOREAN,
                MenuCategory.KOREAN,
                MenuCategory.CHINESE
        );

    }

    private static Stream<Arguments> provideValidRandomCategoryNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 0, 4, 5)),
                Arguments.of(List.of(1, 0, 0, 2, 3, 4, 0, 5))
        );
    }

    private static Stream<Arguments> provideRandomCategoryNumbersForOverFrequency() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(1, 1, 1, 2, 3)), List.of(1, 2, 3, 4, 5)),
                Arguments.of(new ArrayList<>(List.of(1, 1, 2, 2, 2)), List.of(1, 2, 3, 4, 5))
        );
    }

    private static Stream<Arguments> provideRandomCategoryNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 0, 4, 5)),
                Arguments.of(List.of(1, 0, 0, 2, 3, 4, 0, 5))
        );
    }
}
