package calculator.siemens.core;

import calculator.siemens.core.expression.ArithmeticExpression;
import calculator.siemens.core.expression.ArithmeticExpressionImpl;

/**
 *
 *
 */
public class CalculatorImpl implements Calculator {





    public CalculatorResult calculate(String expression) {
        if(expression==null){
            throw new NullPointerException("Input expression must not be null");
        }
        ArithmeticExpression arithmeticExpression = initNewArithmeticExpression();

        String error = arithmeticExpression.deserialize(expression);
        if(error!=null){
            /*CalculatorResult result = new CalculatorResult();
            result.setError(error);
            result.setSuccess(false);*/
            return new CalculatorResult(error);
        }



        return arithmeticExpression.calculate();
    }

    private ArithmeticExpression initNewArithmeticExpression(){
        return new ArithmeticExpressionImpl();
    }
}
