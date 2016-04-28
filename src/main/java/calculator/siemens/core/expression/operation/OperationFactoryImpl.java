package calculator.siemens.core.expression.operation;

import calculator.siemens.core.expression.ArithmeticExpressionItem;
import calculator.siemens.core.expression.operation.impl.*;

/**
 *
 */
public class OperationFactoryImpl implements OperationFactory {

    public Operation getOperation(char operation) {
        Operation item = null;
        if (operation == '+') {
            item = new AddOperation();
        } else if (operation == '-') {
            item = new SubOperation();
        } else if (operation == '/') {
            item = new DivOperation();
        } else if (operation == '*') {
            item = new MultOperation();
        }

        return item;
    }
}
