package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CategoriesPickerTest {
    @Test
    void pick() {
        CategoriesPicker categoriesPicker = new CategoriesPicker(new RandomNumberGenerator());
        Categories categories = categoriesPicker.pick();
        assertThat(categories.getCategories()).hasSize(5);
    }
}
