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
        while (categories.size() < 5) {
            int categoryIndex = numberGenerator.generate();
            Category category = Category.fromIndex(categoryIndex);
            if (isValidDuplicates(categories, category)){
                categories.add(category);
            }
        }
        return Categories.from(categories);
    }

    private boolean isValidDuplicates(List<Category> categories, Category category) {
        List<Category> targetCategories = new ArrayList<>(categories);
        targetCategories.add(category);
        return targetCategories.size() - Set.copyOf(targetCategories).size() <= 1;
    }
}
