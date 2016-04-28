package calculator.siemens.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class CalculatorResultTest {
    private CalculatorResult result = new CalculatorResult(0);

    @Test                                                       // для каждого @Test создается свой объект result = new CalculatorResult();
    public void isSuccess_Test(){
        assertFalse(result.isSuccess());

        result.setSuccess(true);
        assertTrue(result.isSuccess());

        result.setSuccess(false);
        assertFalse(result.isSuccess());
    }

    @Test
    public void testSetSuccess() throws Exception {
        result.setSuccess(true);
        assertEquals(true,result.isSuccess());

        result.setSuccess(false);
        assertEquals(false,result.isSuccess());
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(0.0,result.getValue(),0);
        result.setValue(5);
        assertEquals(5.0,result.getValue(),0);
    }

    @Test
    public void testSetValue() throws Exception {
        result.setValue(0.0);
        assertEquals(0.0,result.getValue(),0);
        result.setValue(10);
        assertEquals(10.0,result.getValue(),0);
    }

    @Test
    public void testSetError() throws Exception {

        result.setError("mistake");
        assertEquals("mistake",result.getError());

        result.setError("error");
        assertEquals("error",result.getError());

        result.setError("");
        assertEquals("",result.getError());
    }

    @Test
    public void testGetError() {

        assertEquals(null,result.getError());

        result.setError("");
        assertEquals("",result.getError());

        result.setError("abc");
        assertEquals("abc",result.getError());

    }
}
