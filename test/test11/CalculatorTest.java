package test11;

import org.junit.Test;
import task11.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public class CalculatorTest {
  @Test
  public void happyPath() {
    Calculator calculator=new Calculator();
  assertThat(calculator.onEqualPressed("1.2+1.5*4/2+15"),is("19.2"));
  }
  @Test
  public void devisionByZero() {
     Calculator calculator=new Calculator();
    try{
      calculator.onEqualPressed("66+6/0");
    }
    catch (IllegalStateException ex){
      assertThat(ex.getMessage(),is("Devision by zero!"));
    }
  }
  @Test
  public void tooManyOperators() {
    Calculator calculator=new Calculator();
    try{
      calculator.onEqualPressed("5++3-99");
    }
    catch (IllegalStateException ex){
      assertThat(ex.getMessage(),is("Incorrect input!"));
    }
  }
  @Test
  public void tooManyDots() {
    Calculator calculator=new Calculator();
    try{
      calculator.onEqualPressed("3..5+66/6");
    }
    catch (IllegalStateException ex){
      assertThat(ex.getMessage(),is("Devision by zero!"));
    }
  }
}
