package task11;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public abstract class Operation implements Symbol {
  public Stack<String> stack;
  public int priority;
  public Map<String, Symbol> map;
  private String value;

  protected Operation(Stack<String> stack, int priority, String value, Map<String, Symbol> map) {
    this.stack = stack;
    this.priority = priority;
    this.value = value;
    this.map = map;
  }

  public int getPriority() {
    return priority;
  }

  public void doSomeJob() {
    String operand1 = "";
    String operand2 = "";
    int i = 0;
    while (i < 3 && !stack.empty()) {
      String s = stack.pop();
      if (s.equals(" ")) {
        i++;
      } else {
        if (i == 1) {
          operand2 = s + operand2;
        }
        if (i == 2) {
          operand1 = s + operand1;
        }

      }
    }
    stack.push(" ");
    stack.push(doOperationAction(operand1, operand2));

  }

  public String convert(String task) {
    while (!stack.empty() && (this.priority <= (map.get(stack.peek()).getPriority()))) {
      task += " ";
      task += stack.pop();
    }
    task += " ";
    stack.push(value);
    return task;
  }

  abstract public String doOperationAction(String operand1, String operand2);
}
