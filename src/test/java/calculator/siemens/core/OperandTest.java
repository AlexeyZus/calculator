package calculator.siemens.core;

import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class OperandTest {

    @Test
    public void operand_getValue(){

        Operand operand = new Operand(0.0);
        assertNotNull(operand);
        assertEquals(0.0,operand.getValue(),0.00001);
        assertTrue(operand.isOperand());
        assertFalse(operand.isOperation());

        Operand operand1 = new Operand(3.0);
        assertNotNull(operand1);
        assertTrue(operand1.isOperand());
        assertFalse(operand1.isOperation());
        assertEquals(3.0,operand1.getValue(),0.00001);

        Operand operand2 = new Operand(-1.0);
        assertNotNull(operand2);
        assertTrue(operand2.isOperand());
        assertFalse(operand2.isOperation());
        assertEquals(-1.0,operand2.getValue(),0.00001);

        Operand operand3 = new Operand(1);
        assertNotNull(operand3);
        assertTrue(operand3.isOperand());
        assertFalse(operand3.isOperation());
        assertEquals(1.0,operand3.getValue(),0.00001);

        Operand operand4 = new Operand(001);
        assertNotNull(operand4);
        assertTrue(operand4.isOperand());
        assertFalse(operand4.isOperation());
        assertEquals(1.0,operand4.getValue(),0.00001);

        operand=null;
        operand1=null;
        operand2=null;
        operand3=null;
        operand4=null;
    }




}
