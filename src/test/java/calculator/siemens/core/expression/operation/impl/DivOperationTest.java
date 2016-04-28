package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class DivOperationTest {
    @Test
    public void divOperation_test(){
        DivOperation divOperation = new DivOperation();
        assertNotNull(divOperation);
        assertFalse(divOperation.isOperand());
        assertTrue(divOperation.isOperation());
        CalculatorResult result = divOperation.calculate(new Operand(5),new Operand(5));
        assertNotNull(result);
        assertEquals(1.0,result.getValue(),0.000001);

        CalculatorResult result1 = divOperation.calculate(new Operand(0),new Operand(0));
        assertNotNull(result1);
        assertEquals(0.0,result1.getValue(),0.000001);

        CalculatorResult result2 = divOperation.calculate(new Operand(5),new Operand(5));
        assertNotNull(result2);
        assertEquals(1.0,result2.getValue(),0.000001);
    }

    @Test
    public void divOperation_testDivNull(){
        DivOperation divOperation = new DivOperation();
        assertNotNull(divOperation);
        assertFalse(divOperation.isOperand());
        assertTrue(divOperation.isOperation());
        CalculatorResult result1 = divOperation.calculate(new Operand(0),new Operand(0));
        assertFalse(result1.isSuccess());


        CalculatorResult result2 = divOperation.calculate(new Operand(-5),new Operand(5));
        assertNotNull(result2);
        assertEquals(-1.0,result2.getValue(),0.000001);
    }
}
