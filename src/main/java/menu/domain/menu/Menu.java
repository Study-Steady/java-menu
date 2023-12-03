package menu.domain.menu;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Menu {

    private final String name;

    public Menu(String name) {
        this.name = name;
    }

    public static List<Menu> namesOf(List<String> menuNames) {
        return menuNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList());
    }

    public boolean matchesName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
