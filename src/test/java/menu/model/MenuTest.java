package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 메뉴에_존재하지_않은_이름인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Menu.from("존재하지 않는 메뉴"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴에_존재하는_이름인_경우_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Menu.from("깐풍기"));
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
    void 메뉴가_추천하는_메뉴에_없으면_true를_반환한다() {
        RecommendMenus recommendMenus = new RecommendMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(recommendMenus.notInclude(Menu.BIBIMBAP)).isTrue();
    }

    @Test
    void 메뉴가_추천하는_메뉴에_있으면_false를_반환한다() {
        RecommendMenus recommendMenus = new RecommendMenus(List.of(Menu.BULGOGI, Menu.KIMCHI_JJIGAE));

        assertThat(recommendMenus.notInclude(Menu.BULGOGI)).isFalse();
    }
}
