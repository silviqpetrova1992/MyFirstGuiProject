package task1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/19/15.
 */
public class Calculator {
  private char action = ' ';
  private double operand1 = 0;
  private double operand2 = 0;
  private double result = 0;
  private String field="";

  public String getText() {
    return field;
  }

  public String onNumberPressed(String number) {
    String s=field;
    field=s+number;
    return field;
  }

  public void resetValues() {
    operand1 = 0;
    operand2 = 0;
    action = ' ';
    result = 0;
  }
public  String onDotPressed(){
  String s=field;
  field=s+'.';
  return field;
}
  public String onEqualPressed(){
      if (action != ' ') {
        operand2 = Double.parseDouble(field.substring(field.lastIndexOf(action) + 1, field.length()));
        if (action == '+') {
          result = operand1 + operand2;
        }
        if(action=='-'){
          result=operand1-operand2;
        }
        if(action=='x'){
          result=operand1*operand2;
        }
        if(action=='/'){
          if(operand2==0){
            field="Devision by zero!";
            resetValues();
            return field;
          }
          result=operand1/operand2;
        }
       field=String.valueOf(result);
        resetValues();
      }
    return field;
}
  public String onOperationPressed(char c) {
    if (action == ' ' && field.length() != 0) {
      String s=field;
      field=s+c;
      try {
        operand1 = Double.parseDouble(s.toString());
        action = c;
      } catch (Exception ex) {
       field="Incorrect input";
        resetValues();
        return field;
      }
    }
    if (action == ' ' && field.length() == 0 && ((c == '+') || (c == '-'))) {
      String s=field;
      field=s+c;
    }
    return field;
  }
  public  String onClearPressed(){
    char lastChar = field.charAt(field.length() - 1);
    if (lastChar == '+' || lastChar == '-' || lastChar == 'x' || lastChar == '/') {
      action = ' ';
    }
    field=field.substring(0, field.length() - 1);
    return field;
  }
  public String onClearAllPressed(){
    resetValues();
    field="";
    return field;
  }
        }
