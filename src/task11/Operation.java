package task11;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public abstract class Operation implements Symbol {
  public Stack<String> stack;
  public String priority;
  public Map<String, Symbol> map;
  private String value;

  protected Operation(Stack<String> stack, String priority, String value, Map<String, Symbol> map) {
    this.stack = stack;
    this.priority = priority;
    this.value = value;
    this.map = map;
  }

  public String getPriority() {
    return priority;
  }

  public void doSomeJob() {
    String operand1;
    String operand2;
    if (stack.size() < 2) {
      throw new IllegalArgumentException("Incorrect input!");
    }
    operand2 = stack.pop();
    operand1 = stack.pop();
    stack.push(doOperationAction(operand1, operand2));

  }

  public String convert(String task) {
    while (!stack.empty() && (this.priority.compareTo(map.get(stack.peek()).getPriority()) <= 0)) {
      task += stack.pop();
    }
    stack.push(value);
    return task;
  }

  abstract public String doOperationAction(String operand1, String operand2);
}
