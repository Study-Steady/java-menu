package menu.exception;

public enum ExceptionSymbol {
    PREFIX("[ERROR] "),
    ;

    private final String symbol;

    ExceptionSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
