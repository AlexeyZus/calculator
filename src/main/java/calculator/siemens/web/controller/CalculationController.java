package calculator.siemens.web.controller;

import calculator.siemens.core.Calculator;
import calculator.siemens.core.CalculatorImpl;
import calculator.siemens.core.CalculatorResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 */
@RestController
public class CalculationController {

    private Calculator calculator = new CalculatorImpl();

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public CalculatorResult calculate (@Valid @RequestBody CalculateRequest request){
        return calculator.calculate(request.getExpression());
    }

    @RequestMapping(value = "/calculate2", method = RequestMethod.GET)
    public CalculatorResult calculate2 (@RequestParam(value="expression") String expression){
        return calculator.calculate(expression);
    }

    public static class CalculateRequest{
        private String expression;

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }
    }


}
