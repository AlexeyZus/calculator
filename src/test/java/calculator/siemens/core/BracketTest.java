package calculator.siemens.core;

import calculator.siemens.core.expression.Bracket;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class BracketTest {

    @Test
    public void brackets_test(){
        Bracket bracket = Bracket.CLOSE_BRACKET;
        assertNotNull(bracket);
        assertTrue(bracket.isBrackets());
        assertFalse(bracket.isOperation());
        assertFalse(bracket.isOperand());

        bracket = Bracket.OPEN_BRACKET;
        assertNotNull(bracket);
        assertTrue(bracket.isBrackets());
        assertFalse(bracket.isOperation());
        assertFalse(bracket.isOperand());
    }
}
