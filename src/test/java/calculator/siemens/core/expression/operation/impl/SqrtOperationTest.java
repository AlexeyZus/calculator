package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class SqrtOperationTest {


    @Test
    public void sqrtOperation_test(){

        SqrtOperation sqrtOperation = new SqrtOperation();
        assertNotNull(sqrtOperation);
        assertFalse(sqrtOperation.isOperand());
        assertTrue(sqrtOperation.isOperation());

        CalculatorResult result = sqrtOperation.calculate(new Operand(5));
        assertNotNull(result);
        assertEquals(2.236,result.getValue(),0.000001);

        CalculatorResult result1 = sqrtOperation.calculate(new Operand(0));
        assertNotNull(result1);
        assertEquals(0,result1.getValue(),0.000001);

        CalculatorResult result2 = sqrtOperation.calculate(new Operand(9));
        assertNotNull(result2);
        assertEquals(3,result2.getValue(),0.000001);

    }

    public void sqrtOperation_testNegative(){

        SqrtOperation sqrtOperation = new SqrtOperation();
        assertNotNull(sqrtOperation);
        assertFalse(sqrtOperation.isOperand());
        assertTrue(sqrtOperation.isOperation());

        CalculatorResult result = sqrtOperation.calculate(new Operand(-1));
        assertNotNull(result);
        assertFalse(result.isSuccess());
        assertEquals("Forbidden sqrt by negative expression",result.getError());

    }

}
