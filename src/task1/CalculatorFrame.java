package task1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class CalculatorFrame extends JFrame implements ActionListener {
  private CalculatorPanel panel = new CalculatorPanel();

  private Calculator calculator = new Calculator();


  public void createAndShowGUI() {
    JFrame frame = new JFrame("Calculator!");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(300, 300);
    panel.addComponentsToPane();
    frame.getContentPane().add(panel);
    for (int i = 0; i < panel.buttons.length; i++) {
      panel.buttons[i].button.addActionListener(this);
    }
  }
    @Override
    public void actionPerformed (ActionEvent e){
      String source = ((JButton) e.getSource()).getText();
      if (isDigit(source)) {
        panel.txtField.setText(calculator.onNumberPressed(source));
      }
      if (isOperation(source)) {
        panel.txtField.setText(calculator.onOperationPressed(source.charAt(0)));
      }
      if (source.equals("=")) {
        panel.txtField.setText((calculator.onEqualPressed()));
      }
      if (source.equals(".")) {
        panel.txtField.setText((calculator.onDotPressed()));
      }
      if (source.equals("C")) {
        panel.txtField.setText((calculator.onClearPressed()));
      }
      if (source.equals("CE")) {
        panel.txtField.setText((calculator.onClearAllPressed()));
      }
    }

  private boolean isOperation(String text) {
    return text.equals("+") || text.equals("-") || text.equals("x") || text.equals("/");
  }

  private boolean isDigit(String text) {
    return text.equals("0") || text.equals("1") || text.equals("2") || text.equals("3") ||
            text.equals("4") || text.equals("5") || text.equals("6") || text.equals("7") ||
            text.equals("8") || text.equals("9");
  }

}
