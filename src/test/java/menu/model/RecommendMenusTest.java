package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RecommendMenusTest {

    @Test
    void 기본값으로_추천메뉴가_구성되는_경우는_내부적으로_비어있다() {
        RecommendMenus recommendMenus = new RecommendMenus(List.of());

        assertThat(recommendMenus.getMenus()).isEmpty();
    }

    @Test
    void 추천메뉴가_중복되는_경우에는_예외가_발생한다() {
        List<Menu> menus = List.of(Menu.BULGOGI, Menu.BULGOGI);

        assertThatThrownBy(() -> new RecommendMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 추천메뉴목록에_메뉴를_추가할_수_있다() {
        RecommendMenus recommendMenus = new RecommendMenus(new ArrayList<>());

        recommendMenus.addMenu(Menu.BULGOGI);

        assertThat(recommendMenus.getMenus()).containsExactly(Menu.BULGOGI);
    }

    @Test
    void 추천메뉴에_특정메뉴가_들어있지_않다면_true를_반환한다() {
        RecommendMenus recommendMenus = new RecommendMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(recommendMenus.notInclude(Menu.BIBIMBAP)).isTrue();
    }

    @Test
    void 추천메뉴에_특정메뉴가_들어있다면_false를_반환한다() {
        RecommendMenus recommendMenus = new RecommendMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(recommendMenus.notInclude(Menu.BULGOGI)).isFalse();
    }
}
