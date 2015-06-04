package test11;

import org.junit.Test;
import task11.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public class CalculatorTest {
  Calculator calculator = new Calculator();

  @Test
  public void happyPath() {
    assertThat(calculator.onEqualPressed("1.2+1.5*4/2+15"), is("19.2"));
  }

  @Test
  public void devisionByZero() {
      assertThat(calculator.onEqualPressed("66+6/0"), is("Devision by zero!"));
  }

  @Test
  public void tooManyOperators() {
      assertThat(calculator.onEqualPressed("5++3-99"), is("Incorrect input!"));
  }

  @Test
  public void tooManyDots() {
      assertThat(calculator.onEqualPressed("3..5+66/6"), is("Incorrect input!"));
  }
}
