package menu.domain;

import static menu.domain.Category.ASIAN;
import static menu.domain.Category.JAPAN;
import static menu.domain.Category.WESTERN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WeeklyCategoriesTest {
    @Test
    void recommandMenus() {
        Categories categories = Categories.from(List.of(ASIAN, JAPAN, JAPAN, ASIAN, WESTERN));
        WeeklyCategories weeklyCategories = WeeklyCategories.of(categories, new RandomMenusPicker());
        Player jisu = Player.from(PlayerName.from("지수"), AvoidedMenus.from(List.of("김밥")));
        Player rose = Player.from(PlayerName.from("로제"), AvoidedMenus.from(List.of("김치찌개")));
        Players players = Players.from(List.of(jisu, rose));

        weeklyCategories.recommandMenus(players);

        assertThat(jisu.getWeeklyMenus().getWeekylMenus().size()).isEqualTo(5);
    }
}
