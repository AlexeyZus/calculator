package calculator.siemens.core.expression;

/**
 *
 */
public final class Bracket implements ArithmeticExpressionItem {


    public final static Bracket OPEN_BRACKET = new Bracket('(');
    public final static Bracket CLOSE_BRACKET = new Bracket(')');

    private final char name;

    private Bracket(char name) {
        this.name = name;
    }

    public static Bracket get(char c){
        return c == OPEN_BRACKET.name ? OPEN_BRACKET :
               c == CLOSE_BRACKET.name ? CLOSE_BRACKET :
               null;
    }

    public int getPriority() {
        return 0;
    }

    public boolean isBrackets() {
        return true;
    }

    public boolean isOperand() {
        return false;
    }

    public boolean isOperation() {
        return false;
    }
}
