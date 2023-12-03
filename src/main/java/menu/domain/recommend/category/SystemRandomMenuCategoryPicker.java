package menu.domain.recommend.category;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.MenuCategory;

public class SystemRandomMenuCategoryPicker implements RandomMenuCategoryPicker {

    @Override
    public MenuCategory pick(int minMenuNoInclusive, int maxMenuNoInclusive) {
        return MenuCategory.getByMenuNo(Randoms.pickNumberInRange(maxMenuNoInclusive, maxMenuNoInclusive));
    }

}
