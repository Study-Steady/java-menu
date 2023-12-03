package menu.domain.menu;

import static menu.domain.menu.Menu.김치찌개;
import static menu.domain.menu.Menu.불고기;
import static menu.domain.menu.Menu.비빔밥;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuHistoryTest {
    private MenuHistory history;

    @BeforeEach
    void setUp() {
        history = MenuHistory.create();
    }

    @DisplayName("같은 카테고리의 메뉴를 3개 이상 추가하면 예외가 발생한다.")
    @Test
    void testMenuCategoryOverThreshHold() {
        // given
        List<Menu> menus = List.of(불고기, 비빔밥, 김치찌개);

        for (int i = 0; i < menus.size() - 1; i++) {
            history.addMenu(menus.get(i));
        }

        // when, then
        assertThatThrownBy(() -> history.addMenu(menus.get(menus.size() - 1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일 메뉴를 두 번 추천하면 예외를 발생시킨다")
    @Test
    void testDuplicateMenu() {
        // given
        List<Menu> menus = List.of(불고기, 비빔밥, 불고기);

        for (int i = 0; i < menus.size() - 1; i++) {
            history.addMenu(menus.get(i));
        }

        // when, then
        assertThatThrownBy(() -> history.addMenu(menus.get(menus.size() - 1)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}