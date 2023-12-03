package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    void recommandMenus() {
        Category category = Category.ASIAN;
        Player jisu = Player.from(PlayerName.from("지수"), AvoidedMenus.from(List.of("김밥")));
        Player rose = Player.from(PlayerName.from("로제"), AvoidedMenus.from(List.of("김치찌개")));
        Players players = Players.from(List.of(jisu, rose));
        MenusPicker menusPicker = new MenusPicker() {
            @Override
            public Menu pick(List<String> menus, Player player) {
                return  Menu.from("팟타이");
            }
        };
        category.recommandMenus(Day.MONDAY, players, menusPicker);

        assertThat(jisu.getWeeklyMenus().getWeekylMenus().values()).contains(Menu.from("팟타이"));
    }
}
