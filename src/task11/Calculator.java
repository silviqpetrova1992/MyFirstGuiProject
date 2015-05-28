package task11;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/27/15.
 */
public class Calculator {
  private String task;
  Stack<String> stack = new Stack<String>();
  Map<String, Symbol> map = new HashMap<String, Symbol>();

  public Calculator() {
  }

  private void prepare() {
    map.put("0", new NonOperation(stack, "0"));
    map.put("1", new NonOperation(stack, "1"));
    map.put("2", new NonOperation(stack, "2"));
    map.put("3", new NonOperation(stack, "3"));
    map.put("4", new NonOperation(stack, "4"));
    map.put("5", new NonOperation(stack, "5"));
    map.put("6", new NonOperation(stack, "6"));
    map.put("7", new NonOperation(stack, "7"));
    map.put("8", new NonOperation(stack, "8"));
    map.put("9", new NonOperation(stack, "9"));
    map.put(" ",new NonOperation(stack," "));
    map.put(".",new NonOperation(stack,"."));
    map.put("E",new NonOperation(stack,"E"));
    map.put("+", new Operation(stack, 1,"+",map) {
      @Override
      public String doOperationAction(String operand1, String operand2) {
        try{
        return String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
        }catch (Exception e){
          throw new IllegalStateException("Incorrect input!");
        }
      }
    });
    map.put("-", new Operation(stack, 1,"-",map) {
      @Override
      public String doOperationAction(String operand1, String operand2) {
        try{
        return String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
      }catch (Exception e){
          throw new IllegalStateException("Incorrect input!");
      }
      }
    });
    map.put("*", new Operation(stack, 2,"*",map) {
      @Override
      public String doOperationAction(String operand1, String operand2) {

        try{
        return String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
      }catch (Exception e){
          throw new IllegalStateException("Incorrect input!");
      }
      }
    });
    map.put("/",new Operation(stack, 2,"/",map) {
      @Override
      public String doOperationAction(String operand1, String operand2) {
        if(operand2.equals("0")){
          throw new IllegalStateException("Devision by zero!");
        }
        try{
          return String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
        }catch (Exception e){
          throw new IllegalStateException("Incorrect input!");
        }
      }
    });
  }

  public String onEqualPressed(String task) {
    this.task=task;
    this.prepare();
    this.task= this.convert();
    try{
    return this.calculate();
    }
      catch(Exception ex){
       // System.err.println(ex.getMessage());
        return ex.getMessage();
      }
  }

  private String calculate() {
    stack.clear();
    while (task.length() != 0) {
      try {
        map.get(String.valueOf(task.charAt(0))).doSomeJob();
      } catch (NullPointerException ex) {
        System.out.println("Undefined symbol!" + task.charAt(0));
        return null;
      }
      task = task.substring(1, task.length());
    }
    if (stack.size() != 2) {
      throw new IllegalArgumentException("Incorrect input");
    }
    return stack.pop();
  }

  private String convert() {
    stack.clear();
    String convertedTask = " ";
    while (task.length() != 0) {
   convertedTask=map.get(String.valueOf(task.charAt(0))).convert(convertedTask);
      task = task.substring(1, task.length());
    }
    while (!stack.empty()) {
      convertedTask+=" ";
      convertedTask += stack.pop();
    }
    return convertedTask;
  }


}
