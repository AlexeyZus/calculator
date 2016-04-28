package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import calculator.siemens.core.expression.operation.BinaryOperation;

/**
 *
 */
public class SubOperation extends BinaryOperation {





    @Override
    public CalculatorResult calculate(Operand operand1, Operand operand2) {
        CalculatorResult calculatorResult = new CalculatorResult(operand1.getValue()-operand2.getValue());
        calculatorResult.setSuccess(true);
        return calculatorResult;
    }
    public int getPriority() {
        return 1;
    }

    public boolean isOperand() {
        return false;
    }

    public boolean isOperation() {
        return true;
    }


}
