package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class MultOperationTest {
    @Test
    public void multOperation_test(){
        MultOperation multOperation = new MultOperation();
        assertNotNull(multOperation);
        assertFalse(multOperation.isOperand());
        assertTrue(multOperation.isOperation());
        CalculatorResult result = multOperation.calculate(new Operand(5),new Operand(0));
        assertNotNull(result);
        assertEquals(0,result.getValue(),0.000001);

        CalculatorResult result1 = multOperation.calculate(new Operand(0),new Operand(0));
        assertNotNull(result1);
        assertEquals(0,result1.getValue(),0.000001);

        CalculatorResult result2 = multOperation.calculate(new Operand(5),new Operand(5));
        assertNotNull(result2);
        assertEquals(25.0,result2.getValue(),0.000001);

        CalculatorResult result3 = multOperation.calculate(new Operand(-3),new Operand(5));
        assertNotNull(result3);
        assertEquals(-15.0,result3.getValue(),0.000001);
    }
}
