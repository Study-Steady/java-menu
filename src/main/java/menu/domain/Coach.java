package menu.domain;

public class Coach {
    private String name;
    private InedibleMenus inedibleMenus;

    public Coach(String name, InedibleMenus inedibleMenus) {
        this.name = name;
        this.inedibleMenus = inedibleMenus;
    }

    public String getName() {
        return name;
    }

    public boolean isInedibleMenu(String name) {
        return inedibleMenus.isInedibleMenu(name);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", inedibleMenus=" + inedibleMenus +
                '}';
    }
}
