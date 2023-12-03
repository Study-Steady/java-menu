package menu.domain.recommend.menu;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuBoard;
import menu.domain.menu.MenuCategory;

public class MenuPicker {

    private final RandomMenuNamePicker picker;

    public MenuPicker(RandomMenuNamePicker picker) {
        this.picker = picker;
    }

    public Menu pick(Coach coach, MenuCategory pickedCategory, List<Menu> recommendMenu) {
        while (true) {
            String randomPickedMenuName = pickRandomMenuName(pickedCategory);
            Menu menu = MenuBoard.getMenuBy(pickedCategory, randomPickedMenuName);

            if (coach.canEat(menu) && !recommendMenu.contains(menu)) {
                return menu;
            }
        }
    }

    private String pickRandomMenuName(MenuCategory pickedCategory) {
        return picker.pick(MenuBoard.getMenuNamesByCategory(pickedCategory));
    }

}
