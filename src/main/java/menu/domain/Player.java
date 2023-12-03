package menu.domain;

public class Player {
    private final PlayerName playerName;
    private final AvoidedMenus avoidedMenus;
    private final WeeklyMenus weeklyMenus;

    public Player(PlayerName playerName, AvoidedMenus avoidedMenus, WeeklyMenus weeklyMenus) {
        this.playerName = playerName;
        this.avoidedMenus = avoidedMenus;
        this.weeklyMenus = weeklyMenus;
    }

    public static Player from(PlayerName playerName, AvoidedMenus avoidedMenus) {
        return new Player(playerName, avoidedMenus, WeeklyMenus.init());
    }

    public boolean isAvoidedMenu(Menu menu) {
        return avoidedMenus.contains(menu);
    }

    public void applyRecommandMenus(Day day, Menu menu) {
        weeklyMenus.add(day, menu);
    }

    public boolean recommanedMenu(Menu menu) {
        return weeklyMenus.contains(menu);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public WeeklyMenus getWeeklyMenus() {
        return weeklyMenus;
    }
}
