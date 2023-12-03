package menu.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SimpleTimeZone;

public class RecommandMenu {
    private final List<String> menus;

    public RecommandMenu(List<String> menus) {
        this.menus = menus;
    }

    public static RecommandMenu from(Coach coach, List<Menu> categories) {
        Set<String> menus = new HashSet<>();
        for (Menu category : categories) {
            String menuName = MenuRecommander.recommandMenu(category);
            if (coach.isInedibleMenu(menuName)) {
                continue;
            }
            menus.add(menuName);
        }
        return new RecommandMenu(new ArrayList<>(menus));
    }

    public String getMenuNameBy(int index) {
        return menus.get(index);
    }

    @Override
    public String toString() {
        return "RecommandMenu{" +
                "menus=" + menus +
                '}';
    }
}
