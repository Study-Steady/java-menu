package menu.domain;

public class PlayerName {
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 4;
    private final String playerName;

    private PlayerName(String playerName) {
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
        return playerName.length() >= MIN_NAME_LENGTH && playerName.length() <= MAX_NAME_LENGTH;
    }

    public String getPlayerName() {
        return playerName;
    }
}
