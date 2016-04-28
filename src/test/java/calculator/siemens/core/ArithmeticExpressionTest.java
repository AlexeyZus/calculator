package calculator.siemens.core;

import calculator.siemens.core.expression.ArithmeticExpression;
import calculator.siemens.core.expression.ArithmeticExpressionImpl;
import calculator.siemens.core.expression.ArithmeticExpressionItem;
import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class ArithmeticExpressionTest {


    @Test(expected = NullPointerException.class)
    public void deserialize_null(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        expression.deserialize(null);
    }

    @Test
    public void deserialize_oneDigit(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        expression.deserialize("1");
        List<ArithmeticExpressionItem> items = expression.getItems();
        assertEquals(1,items.size());
        ArithmeticExpressionItem item = items.get(0);
        assertNotNull(item);
        assertTrue(item.isOperand());
        Operand operand = (Operand) item;
        assertEquals(1,operand.getValue(),0);

    }

    @Test
    public void deserialize_oneDigitFial(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        expression.deserialize("1+2");
        List<ArithmeticExpressionItem> items = expression.getItems();
        assertEquals(3,items.size());
        ArithmeticExpressionItem item = items.get(2);
        assertNotNull(item);
        assertTrue(item.isOperand());
        Operand operand = (Operand) item;
        assertEquals(1,operand.getValue(),0);
    }

    @Test
    public void deserialize_empty(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        String error = expression.deserialize("");
        assertNotNull(error);
        assertEquals("Input expression is not defined",error);
    }

    @Test
    public void deserialize_correctExpression(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        String error = expression.deserialize("1+1");
        assertNull(error);
        List<ArithmeticExpressionItem> items = expression.getItems();
        assertNotNull(items);
        assertEquals(3,items.size());
    }

    @Test
    public void deserialize_wrongExpression(){
        ArithmeticExpression expression = new ArithmeticExpressionImpl();
        String error = expression.deserialize("1.+1");
        assertNotNull(error);
        assertEquals("Invalid set of elements: 1.+1",error);
    }
}
