package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class AddOperationTest {
    @Test
    public void addOperation_test(){
        AddOperation addOperation = new AddOperation();
        assertNotNull(addOperation);
        assertFalse(addOperation.isOperand());
        assertTrue(addOperation.isOperation());
        CalculatorResult result = addOperation.calculate(new Operand(5),new Operand(5));
        assertNotNull(result);
        assertEquals(10.0,result.getValue(),0.000001);
    }
}
