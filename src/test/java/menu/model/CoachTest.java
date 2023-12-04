package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    void 코치이름으로_코치를_생성할_수_있다() {
        Coach coach = Coach.from("김코치");
        Coach expectedCoach = new Coach(CoachName.from("김코치"), HateMenus.defaultOf(), RecommendMenus.defaultOf());

        assertThat(coach).usingRecursiveComparison().isEqualTo(expectedCoach);
    }

    @Test
    void 싫어하는_메뉴를_추가할_수_있다() {
        Coach coach = Coach.from("김코치");
        Coach expectedCoach = new Coach(CoachName.from("김코치"), HateMenus.from(List.of("짜장면", "짬뽕")),
                RecommendMenus.defaultOf());

        coach.addHateMenus(HateMenus.from(List.of("짜장면", "짬뽕")));

        assertThat(coach).usingRecursiveComparison().isEqualTo(expectedCoach);
    }

    @Test
    void 추천된_메뉴가_싫어하는_메뉴에_속하는_경우_새롭게_추천한다() {
        Coach coach = Coach.from("김코치");
        coach.addHateMenus(HateMenus.from(List.of("김밥", "쌈밥")));
        Coach expectedCoach = new Coach(
                CoachName.from("김코치"),
                HateMenus.from(List.of("김밥", "쌈밥")),
                new RecommendMenus(List.of(Menu.TTEOKBOKKI)));

        List<String> menuNames = List.of("김밥", "쌈밥", "떡볶이");
        Picker picker = new Picker() {
            private final Queue<String> queue = new LinkedList<>(menuNames);

            @Override
            public String pickOne(List<String> values) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return queue.poll();
            }
        };

        coach.recommendedMenu(menuNames, picker);

        assertThat(coach).usingRecursiveComparison().isEqualTo(expectedCoach);
    }

    @Test
    void 추천하고자_하는_메뉴가_이미_추천된_경우라면_다음메뉴를_추천한다() {
        Coach coach = new Coach(
                CoachName.from("김코치"),
                HateMenus.defaultOf(),
                new RecommendMenus(List.of(Menu.TTEOKBOKKI)));
        Coach expectedCoach = new Coach(
                CoachName.from("김코치"),
                HateMenus.defaultOf(),
                new RecommendMenus(List.of(Menu.TTEOKBOKKI, Menu.GIMBAP)));

        List<String> menuNames = List.of("떡볶이", "김밥");
        Picker picker = new Picker() {
            private final Queue<String> queue = new LinkedList<>(menuNames);

            @Override
            public String pickOne(List<String> values) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("더 이상 남은 값이 없습니다.");
                }
                return queue.poll();
            }
        };

        coach.recommendedMenu(menuNames, picker);

        assertThat(coach).usingRecursiveComparison().isEqualTo(expectedCoach);
    }

}
