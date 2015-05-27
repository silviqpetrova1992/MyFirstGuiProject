package task11;

import java.util.Stack;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public class NonOperation implements Symbol {
  public Stack<String> stack;
  public String priority;
  private String value;

  protected NonOperation(Stack<String> stack,String value) {
    this.stack = stack;
    this.priority="number";
    this.value=value;
  }

  @Override
  public String getPriority() {
    return priority;
  }

  public void doSomeJob(){
    stack.push(value);
  }

  @Override
  public String convert(String task) {
    task += value;
    return task;
  }
}

