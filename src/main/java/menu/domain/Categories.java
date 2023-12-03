package menu.domain;

import java.util.List;

public class Categories {
    private final List<Category> categories;

    private Categories(List<Category> categories) {
        this.categories = categories;
    }

    public static Categories from(List<Category> categories) {
        return new Categories(categories);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
