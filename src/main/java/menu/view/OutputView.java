package menu.view;

import menu.domain.Categories;
import menu.domain.Player;
import menu.domain.Players;
import menu.view.formatter.OutputFomatter;
import menu.view.printer.Printer;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printStart() {
        printer.printLine("점심 메뉴 추천을 시작합니다.");
        printer.printEmptyLine();
    }

    public void printResult(Categories rawCategories, Players players) {
        String categories = OutputFomatter.toCategories(rawCategories);

        printer.printLine("메뉴 추천 결과입니다.");
        printer.printLine("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printer.printLine("[ 카테고리 | %s ]", categories);

        players.getPlayer().forEach(this::printPlayerResult);
        printer.printEmptyLine();
        printer.printLine("추천을 완료했습니다.");
    }

    private void printPlayerResult(Player player) {
        String playerName = OutputFomatter.toPlayerName(player);
        String menus = OutputFomatter.toMenus(player);
        printer.printLine("[ %s | %s ]", playerName, menus);
    }

    public void printExceptionMessage(String message) {
        printer.printLine(ERROR_MESSAGE_FORMAT + message);
        printer.printEmptyLine();
    }
}
