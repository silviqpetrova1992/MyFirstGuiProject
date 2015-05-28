package task11;

import task1.Calculator;
import task1.CalculatorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class CalculatorFrame extends JFrame implements ActionListener {
  private task11.CalculatorPanel panel = new task11.CalculatorPanel();

  private task11.Calculator calculator = new task11.Calculator();


  public void createAndShowGUI() {
   // JFrame.setDefaultLookAndFeelDecorated(true);
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
  public void actionPerformed(ActionEvent e) {
    String source = ((JButton) e.getSource()).getText();
    if (source.equals("=")) {
      for (int i = 0; i < panel.buttons.length; i++) {
        panel.buttons[i].button.setEnabled(false);
      }
      System.out.println(panel.txtField.getText());
      panel.txtField.setText((calculator.onEqualPressed(panel.txtField.getText())));
      for (int i = 0; i < panel.buttons.length; i++) {
        panel.buttons[i].button.setEnabled(true);
      }
      return;
    }
    if (source.equals("C")) {
      panel.txtField.setText(panel.txtField.getText().substring(0, panel.txtField.getText().length() - 1));
      return;
    }
    if (source.equals("CE")) {
      panel.txtField.setText("");
      return;
    }
    panel.txtField.setText(panel.txtField.getText() + source);

  }
}
