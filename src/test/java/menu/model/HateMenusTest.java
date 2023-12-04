package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HateMenusTest {

    @Test
    void 싫어하는_메뉴에_문자열에_공백문자가_존재하는_경우_공백문자를_제외한_나머지_메뉴들로_구성한다() {
        List<String> hateMenuNames = List.of(" ", "김치찌개", "된장찌개");

        HateMenus hateMenus = HateMenus.from(hateMenuNames);

        assertThat(hateMenus).usingRecursiveComparison()
                .isEqualTo(new HateMenus(List.of(Menu.KIMCHI_JJIGAE, Menu.DOENJANG_JJIGAE)));
    }

    @Test
    void 싫어하는_메뉴가_최대2개_개수를_넘어서는_경우_예외가_발생한다() {
        List<String> hateMenuNames = List.of("김치찌개", "된장찌개", "부대찌개");

        assertThatThrownBy(() -> HateMenus.from(hateMenuNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideHateMenuNames_유효한범의_메뉴개수")
    void 싫어하는_메뉴의_개수가_유효한_범위내에_있으면_예외가_발생하지_않는다(List<String> hateMenuNames) {
        assertDoesNotThrow(() -> HateMenus.from(hateMenuNames));
    }

    @Test
    void 싫어하는_메뉴에_중복되는_메뉴명이_있다면_예외가_발생한다() {
        List<String> hateMenuNames = List.of("김치찌개", "김치찌개");

        assertThatThrownBy(() -> HateMenus.from(hateMenuNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 싫어하는_메뉴에_중복되는_메뉴명이_없다면_예외가_발생하지_않는다() {
        List<String> hateMenuNames = List.of("김치찌개", "된장찌개");

        assertDoesNotThrow(() -> HateMenus.from(hateMenuNames));
    }

    @Test
    void 싫어하는_메뉴명을_통해서_객체를_생성할_수_있다() {
        String hateMenuName = "김치찌개";

        HateMenus hateMenus = HateMenus.from(List.of(hateMenuName));

        assertThat(hateMenus).usingRecursiveComparison()
                .isEqualTo(new HateMenus(List.of(Menu.KIMCHI_JJIGAE)));
    }

    @Test
    void 기본으로_생성되는_싫어하는_메뉴목록은_비어있다() {
        HateMenus hateMenus = HateMenus.defaultOf();

        assertThat(hateMenus).usingRecursiveComparison()
                .isEqualTo(new HateMenus(List.of()));
    }

    @Test
    void 메뉴가_싫어하는_메뉴에_없으면_true를_반환한다() {
        HateMenus hateMenus = new HateMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(hateMenus.notInclude(Menu.BIBIMBAP)).isTrue();
    }

    @Test
    void 메뉴가_싫어하는_메뉴에_있으면_false를_반환한다() {
        HateMenus hateMenus = new HateMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(hateMenus.notInclude(Menu.BULGOGI)).isFalse();
    }

    @Test
    void 싫어하는_메뉴에_다른_싫어하는_메뉴를_추가할_수_있다() {
        HateMenus hateMenus = new HateMenus(new ArrayList<>(List.of(Menu.KIMCHI_JJIGAE)));
        HateMenus otherHateMenus = new HateMenus(List.of(Menu.DOENJANG_JJIGAE));

        hateMenus.addMenus(otherHateMenus);

        assertThat(hateMenus).usingRecursiveComparison()
                .isEqualTo(new HateMenus(List.of(Menu.KIMCHI_JJIGAE, Menu.DOENJANG_JJIGAE)));
    }

    private static Stream<Arguments> provideHateMenuNames_유효한범의_메뉴개수() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of("김치찌개")),
                Arguments.of(List.of("김치찌개", "된장찌개"))
        );
    }
}
