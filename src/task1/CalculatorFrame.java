package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class CalculatorFrame {
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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    addAction(btn0, "0");
    addAction(btn1, "1");
    addAction(btn2, "2");
    addAction(btn3, "3");
    addAction(btn4, "4");
    addAction(btn5, "5");
    addAction(btn6, "6");
    addAction(btn7, "7");
    addAction(btn8, "8");
    addAction(btn9, "9");
    addAction(btnDot,".");

  }

  private void addAction(JButton btn, final String value) {
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String s = txtField.getText();
        txtField.setText(s + value);
      }
    });
  }

}
