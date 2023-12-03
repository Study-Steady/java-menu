package menu.domain.menu;

import static menu.domain.menu.Menu.뇨끼;
import static menu.domain.menu.Menu.우동;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuBlackListTest {
    private static final Set<String> VALID_BLACKLIST = Set.of("우동", "뇨끼");
    private static final Set<Menu> MENUS = Set.of(우동, 뇨끼);

    @DisplayName("싫어하는 메뉴가 2개 이상이면 예외가 발생한다.")
    @Test
    void testBlackListSizeOver() {
        // given
        Set<String> invalidBlackList = Set.of("불고기", "뇨끼", "깐풍기");

        // when, then
        assertThatThrownBy(() -> MenuBlackList.from(invalidBlackList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("싫어하는 메뉴가 정상적으로 등록되면 해당 메뉴가 들어올 때 알아낼 수 있다.")
    @Test
    void testValidBlackList() {
        // given
        MenuBlackList menuBlackList = MenuBlackList.from(VALID_BLACKLIST);

        // when, then
        assertThat(menuBlackList.contains(우동)).isTrue();
        assertThat(menuBlackList.contains(뇨끼)).isTrue();
    }
}