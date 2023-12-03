package menu.view;


import java.util.List;
import java.util.stream.Collectors;
import menu.common.Symbol;
import menu.domain.AvoidedMenus;
import menu.domain.Player;
import menu.domain.PlayerName;
import menu.domain.PlayerNames;
import menu.domain.Players;
import menu.util.converter.Converter;
import menu.view.printer.Printer;
import menu.view.reader.Reader;
import menu.view.validator.InputValidator;

public class InputView {
    public static final String COACHES_SEPARATOR = Symbol.COMMA;

    private final Reader reader;
    private final Printer printer;

    private InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer);
    }

    public List<String> inputPlayerNames() {
        printer.printLine("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coaches = reader.readLine();
        InputValidator.validateCoaches(coaches, "코치들의 이름");
        return Converter.splitToList(COACHES_SEPARATOR, coaches);
    }

    public Players inputAvoidedMenu(PlayerNames playerNames) {
        List<Player> players = playerNames.getPlayerNames().stream()
                .map(this::inputPlayerAvoidedMenu)
                .collect(Collectors.toList());
        return Players.from(players);
    }

    private Player inputPlayerAvoidedMenu(PlayerName playerName) {
        printer.printLine(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", playerName.getPlayerName()));
        String avoidedMenu = reader.readLine();
        InputValidator.validateAvoidedMenu(avoidedMenu, "못 먹는 메뉴");
        return Player.from(playerName, AvoidedMenus.from(Converter.splitToList(COACHES_SEPARATOR, avoidedMenu)));
    }
}
