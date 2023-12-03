package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoriesPicker {
    private final NumberGenerator numberGenerator;

    public CategoriesPicker(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Categories pick() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() <= 5) {
            Category category = Category.DEFAULT;
            while (isValidDuplicates(categories)) {
                int categoryIndex = numberGenerator.generate();
                category = Category.fromIndex(categoryIndex);
            }
            categories.add(category);
        }
        return Categories.from(categories);
    }

    private boolean isValidDuplicates(List<Category> categories) {
        return categories.size() - Set.copyOf(categories).size() > 1 ;
    }
}
