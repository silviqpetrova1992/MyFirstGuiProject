package task11;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public class CalculatorDemo {
  public static void main(String[] args) {

    Calculator calculator = new Calculator("15.5+14*2-20-10");
    System.out.println(calculator.onEqualPressed());
  }
}
