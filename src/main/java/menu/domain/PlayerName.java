package menu.domain;

public class PlayerName {
    private final String playerName;

    public PlayerName(String playerName) {
        validateLength(playerName);
        this.playerName = playerName;
    }

    public static PlayerName from(String playerName) {
        return new PlayerName(playerName);
    }

    private void validateLength(String playerName) {
        if (!isValidLength(playerName)) {
            throw new IllegalArgumentException("이름은 2~4자 사이여야합니다.");
        }
    }

    private boolean isValidLength(String playerName) {
        return playerName.length() >= 2 && playerName.length() <= 4;
    }

    public String getPlayerName() {
        return playerName;
    }
}
