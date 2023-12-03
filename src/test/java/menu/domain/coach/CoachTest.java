package menu.domain.coach;

import static menu.domain.menu.Menu.짜장면;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuBlackList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    private static final CoachName COACH_NAME = CoachName.from("포비");
    private static final Set<String> RAW_BLACK_LIST = Set.of("우동", "똠양꿍");

    private Coach coach;

    @BeforeEach
    void setUp() {
        coach = Coach.of(COACH_NAME, MenuBlackList.from(RAW_BLACK_LIST));
    }

    @DisplayName("중복된 메뉴는 추가할 수 없다.")
    @Test
    void addDuplicatedMenuTest() {
        // given
        Menu menu = 짜장면;
        coach.addMenu(menu);

        // when & then
        assertThatThrownBy(() -> coach.addMenu(menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("싫어하는 메뉴는 추가할 수 없다.")
    @Test
    void addMenuInBlackListTest() {
        // given
        Menu menu = Menu.fromName("우동");

        // when & then
        assertThatThrownBy(() -> coach.addMenu(menu))
            .isInstanceOf(IllegalArgumentException.class);
    }
}