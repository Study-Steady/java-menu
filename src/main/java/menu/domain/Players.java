package menu.domain;

import java.util.List;

public class Players {
    private final List<Player> player;

    public Players(List<Player> players) {
        this.player = players;
    }

    public static Players from(List<Player> players) {
        return new Players(players);
    }
}
