package menu.domain.recommend;

import java.util.List;
import menu.domain.menu.Menu;
import menu.domain.coach.Coach;

public class MenuRecommendResult {

    private final Coach coach;
    private final List<Menu> recommendedMenu;

    public MenuRecommendResult(Coach coach, List<Menu> recommendedMenu) {
        this.coach = coach;
        this.recommendedMenu = recommendedMenu;
    }

}
