package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class CalculatorFrame extends JFrame {
  private JFrame frame;
  private JTextField txtField;
  private double operand1 = 0;
  private double operand2 = 0;
  private char action = ' ';
  private double result = 0;

  public void createAndShowGUI() {
    frame = new JFrame("Calculator!");
    txtField = new JTextField();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(300, 300);
    addComponentsToPane();
  }

  private void add(JComponent name, int a, int b, GridBagConstraints gridBagConstraints, JPanel panel) {
    gridBagConstraints.gridx = a;
    gridBagConstraints.gridy = b;
    panel.add(name, gridBagConstraints);
  }

  private void addComponentsToPane() {
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn0 = new JButton("0");
    JButton btnDot = new JButton(".");
    JButton btnPlus = new JButton("+");
    JButton btnMinus = new JButton("-");
    JButton btnMultiply = new JButton("x");
    JButton btnDevide = new JButton("/");
    JButton btnClearAll = new JButton("CE");
    JButton btnClear = new JButton("C");
    JButton btnEqual = new JButton("=");

    JPanel panel = new JPanel();
    GridBagLayout gb1 = new GridBagLayout();
    panel.setLayout(gb1);
    gb1.layoutContainer(frame);
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new Insets(5, 5, 5, 5);
    gridBagConstraints.anchor = GridBagConstraints.CENTER;
    gridBagConstraints.fill = GridBagConstraints.BOTH;
///////First line/////////
    txtField.setFont(new Font("SansSerif", Font.BOLD, 20));
    txtField.setHorizontalAlignment(JTextField.RIGHT);
    txtField.setEditable(false);
    txtField.setBackground(Color.WHITE);
    gridBagConstraints.gridwidth = 5;
    add(txtField, 0, 0, gridBagConstraints, panel);
////Second line/////////
    gridBagConstraints.gridwidth = 1;
    add(btn1, 0, 1, gridBagConstraints, panel);

    add(btn2, 1, 1, gridBagConstraints, panel);

    add(btn3, 2, 1, gridBagConstraints, panel);

    add(btnPlus, 3, 1, gridBagConstraints, panel);

    add(btnClearAll, 4, 1, gridBagConstraints, panel);
//////Third line//////
    add(btn4, 0, 2, gridBagConstraints, panel);

    add(btn5, 1, 2, gridBagConstraints, panel);

    add(btn6, 2, 2, gridBagConstraints, panel);

    add(btnMinus, 3, 2, gridBagConstraints, panel);

    add(btnClear, 4, 2, gridBagConstraints, panel);

//////Forth line//////
    add(btn7, 0, 3, gridBagConstraints, panel);

    add(btn8, 1, 3, gridBagConstraints, panel);

    add(btn9, 2, 3, gridBagConstraints, panel);

    add(btnDevide, 3, 3, gridBagConstraints, panel);

    gridBagConstraints.gridheight = 2;
    add(btnEqual, 4, 3, gridBagConstraints, panel);

/////Fifth line////
    gridBagConstraints.gridheight = 1;
    add(btnMultiply, 3, 4, gridBagConstraints, panel);

    add(btnDot, 2, 4, gridBagConstraints, panel);

    gridBagConstraints.gridwidth = 2;
    add(btn0, 0, 4, gridBagConstraints, panel);
    frame.getContentPane().add(panel);
//____________________________//
    ///////Listeners///////
    addNonOperationAction(btn0, "0");
    addNonOperationAction(btn1, "1");
    addNonOperationAction(btn2, "2");
    addNonOperationAction(btn3, "3");
    addNonOperationAction(btn4, "4");
    addNonOperationAction(btn5, "5");
    addNonOperationAction(btn6, "6");
    addNonOperationAction(btn7, "7");
    addNonOperationAction(btn8, "8");
    addNonOperationAction(btn9, "9");
    addNonOperationAction(btnDot, ".");
    //For the Clear button
    btnClear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String s = txtField.getText();
        char lastChar = s.charAt(s.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == 'x' || lastChar == '/') {
          action = ' ';
        }
        txtField.setText(s.substring(0, s.length() - 1));
      }
    });
    //For the ClearAll button
    btnClearAll.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
 resetValues();
        txtField.setText("");
      }
    });
    //For the Plus button
   addOperationAction(btnPlus,'+');
    //For the Minus button
  addOperationAction(btnMinus,'-');
    //For the Multiply button
    addOperationAction(btnMultiply,'x');
    //For The Devide button
    addOperationAction(btnDevide,'/');

    //For the Equal button
    btnEqual.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (action != ' ') {
          String s = txtField.getText();
          operand2 = Double.parseDouble(s.substring(s.lastIndexOf(action) + 1, s.length()));
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
              txtField.setText("Devision by zero!");
              resetValues();
              return;
            }
            result=operand1/operand2;
          }
          txtField.setText(String.valueOf(result));
        resetValues();
        }
      }
    });
  }
private void addOperationAction(JButton btn, final char c){
  btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      String s = txtField.getText();
      if (action == ' '&&s.length()!=0) {

        txtField.setText(s + c);
        try {
          operand1 = Double.parseDouble(s);
          action = c;
        } catch (Exception ex) {
          txtField.setText("Incorrect input");
          resetValues();
        }
      }
      if (action ==' '&&s.length()==0&&((c=='+')||(c=='-'))){
        s = txtField.getText();
        txtField.setText(s + c);
      }
    }
  });
}

  private void resetValues() {
    operand1 = 0;
    operand2 = 0;
    action = ' ';
    result = 0;
  }

  private void addNonOperationAction(JButton btn, final String value) {
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String s = txtField.getText();
        txtField.setText(s + value);
      }
    });
  }

}
