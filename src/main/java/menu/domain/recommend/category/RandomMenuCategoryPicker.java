package menu.domain.recommend.category;

import menu.domain.menu.MenuCategory;

public interface RandomMenuCategoryPicker {

    MenuCategory pick(int minMenuNo, int maxMenuNo);

}
