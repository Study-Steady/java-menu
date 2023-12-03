package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

public class RandomMenuPickerTest {
    @RepeatedTest(10)
    void pick() {
        MenusPicker menusPicker = new RandomMenusPicker();
        List<String> menus = List.of("규동", "우동", "미소시루");
        Player jisu = Player.from(PlayerName.from("지수"),
                AvoidedMenus.from(List.of("규동", "우동")));

        Menu menu = menusPicker.pick(menus, jisu);

        assertThat(menu).isEqualTo(Menu.from("미소시루"));
    }
}
