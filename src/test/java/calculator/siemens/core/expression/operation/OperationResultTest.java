package calculator.siemens.core.expression.operation;

import calculator.siemens.core.expression.Operand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class OperationResultTest {

    @Test
    public  void isSuccess_setError(){
        OperationResult operationResult = new OperationResult();
        assertNotNull(operationResult);
        operationResult.setError("error");
        assertEquals("error",operationResult.getError());
    }

    @Test
    public  void isSuccess_test(){
        OperationResult operationResult = new OperationResult();
        assertNotNull(operationResult);
        assertFalse(operationResult.isSuccess());
        operationResult.setSuccess(true);
        assertTrue(operationResult.isSuccess());
    }

    @Test
    public void getResult_test(){
        OperationResult operationResult = new OperationResult();
        assertNotNull(operationResult);
        operationResult.setResult(new Operand(5));
        assertEquals(5,operationResult.getResult().getValue(),0.000001);

    }



}
