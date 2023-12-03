package menu.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuCategoryGroupTest {
    private MenuCategoryGroup menuCategoryGroup;

    @BeforeEach
    void setUp() {
        menuCategoryGroup = MenuCategoryGroup.create();
    }

    @DisplayName("메뉴 카테고리에는 동일한 카테고리가 최대 2개까지만 존재한다.")
    @Test
    void menuCategoryFrequencyTest() {
        // given
        List<MenuCategory> menuCategories = menuCategoryGroup.getMenuCategoryGroup();

        // when
        int maxFrequency = 0;
        for (MenuCategory category: MenuCategory.values()) {
            if (menuCategories.contains(category)) {
                maxFrequency = Math.max(maxFrequency, Collections.frequency(menuCategories, category));
            }
        }

        // then
        assertThat(maxFrequency).isLessThanOrEqualTo(2);
    }
}