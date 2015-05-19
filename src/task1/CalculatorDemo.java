package task1;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/19/15.
 */
public class CalculatorDemo {
  public static void main(String[] args) {
    Calculator calculator=new Calculator();
    calculator.onOperationPressed('-');
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("5");
    calculator.onDotPressed();
    calculator.onNumberPressed("5");
    calculator.onOperationPressed('+');
    calculator.onOperationPressed('+');
    calculator.onClearAllPressed();
    calculator.onNumberPressed("5");
    calculator.onNumberPressed("0");
    calculator.onOperationPressed('-');
    calculator.onNumberPressed("10");
    calculator.onEqualPressed();
    calculator.onEqualPressed();
    System.out.println(calculator.getText());
  }
}
