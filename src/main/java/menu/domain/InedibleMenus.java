package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.util.StringConvertor;

public class InedibleMenus {
    private final List<String> menus;

    private InedibleMenus(List<String> menus) {
        this.menus = menus;
    }

    public static InedibleMenus from(String menuNames) {
        return new InedibleMenus(Arrays.asList(StringConvertor.splitByComma(menuNames)));
    }


    @Override
    public String toString() {
        return "InedibleMenus{" +
                "menus=" + menus +
                '}';
    }
}
