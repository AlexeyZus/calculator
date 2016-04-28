package calculator.siemens.core;

/**
 *
 */
public class MainStart {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new CalculatorImpl();

        CalculatorResult result = calculator.calculate("4(*(3+3)");
        if(!result.isSuccess())
        System.out.println(result.getError());
        if(result.isSuccess())
        System.out.println(result.getValue());
        Thread.sleep(15000);


    }
}
