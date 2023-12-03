package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.Menu;

public class Coach {

    private final CoachName name;
    private final RestrictedMenu restrictedMenu;
    private final List<Menu> recommended = new ArrayList<>();

    public Coach(CoachName name, RestrictedMenu restrictedMenu) {
        this.name = name;
        this.restrictedMenu = restrictedMenu;
    }

    public String getName() {
        return name.getName();
    }

    public boolean canEat(Menu menu) {
        return !this.restrictedMenu.contains(menu);
    }

    public List<Menu> getRecommended() {
        return recommended;
    }

    public void recommendedMenu(Menu menu) {
        this.recommended.add(menu);
    }

}
