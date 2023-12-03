package menu.utils;

public enum DefaultSymbol {

    DELIMETER(","),
    BLANK(" "),
    RESULT_START("[ "),
    RESULT_END(" ]"),
    RESULT_DELIMETER(" | "),
    CATEGORY("카테고리"),
    DEFINE("구분"),
    NEW_LINE(System.lineSeparator()),
    ;

    private final String symbol;

    DefaultSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}