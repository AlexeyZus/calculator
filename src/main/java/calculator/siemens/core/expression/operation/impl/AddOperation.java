package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import calculator.siemens.core.expression.operation.BinaryOperation;

/**
 *операция - сложение
 */


public class AddOperation extends BinaryOperation {




    private final static int priritet = 1;

    public boolean isOperand() {
        return false;
    }

    public boolean isOperation() {
        return true;
    }

    public int getPriority() {
        return 1;
    }

    @Override
    public CalculatorResult calculate(Operand operand1, Operand operand2) {
        CalculatorResult result = new CalculatorResult(operand1.getValue()+operand2.getValue());
        result.setSuccess(true);
        return result;
    }
}
