package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Category {
    private final List<Menu> category;

    public Category(List<Menu> category) {
        this.category = category;
    }

    public Menu getCategoryBy(int index) {
        return category.get(index);
    }

    public List<String> getCategoryNames() {
        return category.stream()
                .map(Menu::getCategoryName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return category.size();
    }
}
