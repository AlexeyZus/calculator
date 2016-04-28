package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import calculator.siemens.core.expression.operation.BinaryOperation;

/**
 * method calculate - return object class CalculatorResult, which contain result if operation is success, error if operation is fail,
 *
 * Forbidden division to 0 (null)
 */
public class DivOperation extends BinaryOperation {


    public boolean isOperand() {
        return false;
    }

    public boolean isOperation() {
        return true;
    }


    public int getPriority() {
        return 2;
    }

    @Override
    public CalculatorResult calculate(Operand operand1, Operand operand2) {
        double x1 = operand1.getValue();
        double x2 = operand2.getValue();
        if(x2==0){
            CalculatorResult calculatorResult = new CalculatorResult("Forbidden division to 0 (null)");
            calculatorResult.setSuccess(false);
            return calculatorResult;

        }

        CalculatorResult calculatorResult = new CalculatorResult(operand1.getValue()/operand2.getValue());
        calculatorResult.setSuccess(true);
        return calculatorResult;
    }
}
