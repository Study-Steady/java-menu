package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_PLAYER_COUNT = 5;
    private final List<PlayerName> playerNames;

    private PlayerNames(List<PlayerName> playerNames) {
        validateCount(playerNames);
        this.playerNames = playerNames;
    }

    public static PlayerNames from(List<String> playerNames) {
        return new PlayerNames(convertToPlayerNames(playerNames));
    }

    private static List<PlayerName> convertToPlayerNames(List<String> playerNames) {
        return playerNames.stream()
                .map(PlayerName::from)
                .collect(Collectors.toList());
    }

    private void validateCount(List<PlayerName> playerNames) {
        if (!isValidCount(playerNames)) {
            throw new IllegalArgumentException("코치는 2~5명 사이여야합니다.");
        }
    }

    private boolean isValidCount(List<PlayerName> playerNames) {
        return playerNames.size() >= MIN_PLAYER_COUNT && playerNames.size() <= MAX_PLAYER_COUNT;
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }
}
