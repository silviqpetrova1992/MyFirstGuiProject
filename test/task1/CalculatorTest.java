package task1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/20/15.
 */
public class CalculatorTest {
  Calculator calculator;
  @Before
  public  void setUp(){
    calculator=new Calculator();
  }
@Test
  public void happyPathForPlus(){
  calculator.onNumberPressed("5");
  calculator.onOperationPressed('+');
  calculator.onNumberPressed("6");
  assertThat(calculator.onEqualPressed(),is("11.0"));
}
  @Test
  public void anotherHappyPathForPlus(){
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    calculator.onOperationPressed('+');
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("9");
    assertThat(calculator.onEqualPressed(),is("1.0"));
  }
  @Test
  public void doubleClickOnOperation() {
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    calculator.onOperationPressed('+');
    calculator.onOperationPressed('+');
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("9");
    assertThat(calculator.onEqualPressed(),is("1.0"));
  }
  @Test
  public void happyPathForMinus(){
    calculator.onNumberPressed("8");
    calculator.onOperationPressed('-');
    calculator.onNumberPressed("1");
    calculator.onNumberPressed("6");
    assertThat(calculator.onEqualPressed(),is("-8.0"));
  }
  @Test
  public void anotherHappyPathForMinus(){
    calculator.onNumberPressed("0");
    calculator.onOperationPressed('-');
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("9");
    assertThat(calculator.onEqualPressed(),is("-0.9"));
  }
  @Test
  public void happyPathForMultiply(){
    calculator.onNumberPressed("8");
    calculator.onOperationPressed('x');
    calculator.onNumberPressed("6");
    assertThat(calculator.onEqualPressed(),is("48.0"));
  }
  @Test
  public void happyPathForDevide(){
    calculator.onNumberPressed("8");
    calculator.onNumberPressed("8");
    calculator.onOperationPressed('/');
    calculator.onNumberPressed("1");
    calculator.onNumberPressed("1");
    assertThat(calculator.onEqualPressed(),is("8.0"));
  }
  @Test
  public void devisionByZero() {
    calculator.onNumberPressed("8");
    calculator.onOperationPressed('/');
    calculator.onNumberPressed("0");
    assertThat(calculator.onEqualPressed(),is("Devision by zero!"));
  }
@Test
public void MultipleDotsInANumber() {
  calculator.onNumberPressed("0");
  calculator.onDotPressed();
  calculator.onNumberPressed("1");
  calculator.onDotPressed();
  calculator.onNumberPressed("1");
  assertThat(calculator.onOperationPressed('+'),is("Incorrect input"));
}
  @Test
  public void happyPathForClearAll() {
    calculator.onNumberPressed("5");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    assertThat(calculator.onClearAllPressed(),is(""));
  }
  @Test
  public void happyPathForClear() {
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    assertThat(calculator.onClearPressed(),is("0."));
  }
  @Test
  public void clearTheLastOperation() {
    calculator.onNumberPressed("0");
    calculator.onDotPressed();
    calculator.onNumberPressed("1");
    calculator.onOperationPressed('x');
    calculator.onClearPressed();
    calculator.onOperationPressed('+');
    calculator.onNumberPressed("1");
    assertThat(calculator.onEqualPressed(), is("1.1"));
  }
}
