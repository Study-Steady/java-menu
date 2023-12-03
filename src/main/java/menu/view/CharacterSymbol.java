package menu.view;

public enum CharacterSymbol {

    BLANK(" "),
    COMMA(",");

    private final String literal;

    CharacterSymbol(String symbolLiteral) {
        this.literal = symbolLiteral;
    }

    public String getLiteral() {
        return literal;
    }

}
