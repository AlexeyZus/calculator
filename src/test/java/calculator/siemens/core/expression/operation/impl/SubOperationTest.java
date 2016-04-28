package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;

import static org.junit.Assert.*;

/**
 *
 */
public class SubOperationTest {
    public void subOperation_testNegative(){

        SubOperation subOperation = new SubOperation();
        assertNotNull(subOperation);
        assertFalse(subOperation.isOperand());
        assertTrue(subOperation.isOperation());

        {
            CalculatorResult result = subOperation.calculate(new Operand(-1), new Operand(5));
            assertNotNull(result);
            assertTrue(result.isSuccess());
            assertEquals(-6.0, result.getValue(), 0.000001);
        }

        {
            CalculatorResult result1 = subOperation.calculate(new Operand(5), new Operand(5));
            assertNotNull(result1);
            assertTrue(result1.isSuccess());
            assertEquals(0, result1.getValue(), 0.000001);
        }
        {
            CalculatorResult result1 = subOperation.calculate(new Operand(10), new Operand(5));
            assertNotNull(result1);
            assertTrue(result1.isSuccess());
            assertEquals(5.0, result1.getValue(), 0.000001);
        }

    }
}
