package calculator.siemens.core.expression.operation;

import calculator.siemens.core.expression.ArithmeticExpressionItem;
import calculator.siemens.core.expression.operation.impl.AddOperation;
import calculator.siemens.core.expression.operation.impl.DivOperation;
import calculator.siemens.core.expression.operation.impl.MultOperation;
import calculator.siemens.core.expression.operation.impl.SubOperation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class OperationFactoryImplTest {

    @Test
    public void factoryItem_test(){
        OperationFactoryImpl operationFactoryImpl = new OperationFactoryImpl();
        assertNotNull(operationFactoryImpl);
        ArithmeticExpressionItem result = operationFactoryImpl.getOperation('+');
        assertTrue(result instanceof AddOperation);
        assertFalse(result instanceof DivOperation);

        result = operationFactoryImpl.getOperation('-');
        assertTrue(result instanceof SubOperation);
        assertFalse(result instanceof DivOperation);

        result = operationFactoryImpl.getOperation(' ');
        assertTrue(result == null);

        result = operationFactoryImpl.getOperation('*');
        assertTrue(result instanceof MultOperation);
        assertFalse(result instanceof DivOperation);

        result = operationFactoryImpl.getOperation('/');
        assertTrue(result instanceof DivOperation);
        assertFalse(result instanceof MultOperation);
    }
}
