package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class CalculatorFrame extends JFrame implements ActionListener {
  private JFrame frame;
  private JTextField txtField;
  private Calculator calculator=new Calculator();
  private PositionedButton[] buttons = new PositionedButton[]{new PositionedButton(new JButton("0"), new Point(0, 4, 2, 1)),
          new PositionedButton(new JButton("1"), new Point(0, 1, 1, 1)), new PositionedButton(new JButton("2"), new Point(1, 1, 1, 1)),
          new PositionedButton(new JButton("3"), new Point(2, 1, 1, 1)), new PositionedButton(new JButton("4"), new Point(0, 2, 1, 1)),
          new PositionedButton(new JButton("5"), new Point(1, 2, 1, 1)), new PositionedButton(new JButton("6"), new Point(2, 2, 1, 1)),
          new PositionedButton(new JButton("7"), new Point(0, 3, 1, 1)), new PositionedButton(new JButton("8"), new Point(1, 3, 1, 1)),
          new PositionedButton(new JButton("9"), new Point(2, 3, 1, 1)), new PositionedButton(new JButton("+"), new Point(3, 1, 1, 1)),
          new PositionedButton(new JButton("CE"), new Point(4, 1, 1, 1)), new PositionedButton(new JButton("-"), new Point(3, 2, 1, 1)),
          new PositionedButton(new JButton("C"), new Point(4, 2, 1, 1)), new PositionedButton(new JButton("/"), new Point(3, 3, 1, 1)),
          new PositionedButton(new JButton("="), new Point(4, 3, 1, 2)), new PositionedButton(new JButton("x"), new Point(3, 4, 1, 1)),
          new PositionedButton(new JButton("."), new Point(2, 4, 1, 1))};

  public void createAndShowGUI() {
    frame = new JFrame("Calculator!");
    txtField = new JTextField();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(300, 300);
    addComponentsToPane();
  }

  private void add(JComponent name, int a, int b, int c, int d, GridBagConstraints gridBagConstraints, JPanel panel) {
    gridBagConstraints.gridx = a;
    gridBagConstraints.gridy = b;
    gridBagConstraints.gridwidth = c;
    gridBagConstraints.gridheight = d;
    panel.add(name, gridBagConstraints);
  }

  private void addComponentsToPane() {
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
    //  gridBagConstraints.gridwidth = 5;
    add(txtField, 0, 0, 5, 1, gridBagConstraints, panel);
////Second line/////////
    for (int i = 0; i < buttons.length; i++) {
      add(buttons[i].button, buttons[i].point.i, buttons[i].point.x, buttons[i].point.y, buttons[i].point.z, gridBagConstraints, panel);
      buttons[i].button.addActionListener(this);
    }
    frame.getContentPane().add(panel);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String source = ((JButton) e.getSource()).getText();
    if (isDigit(source)) {
      txtField.setText(calculator.onNumberPressed(source));
    }
    if (isOperation(source)) {
      txtField.setText(calculator.onOperationPressed(source.charAt(0)));
    }
    if (source.equals("=")) {
      txtField.setText((calculator.onEqualPressed()));
    }
    if (source.equals(".")) {
      txtField.setText((calculator.onDotPressed()));
    }
    if (source.equals("C")) {
      txtField.setText((calculator.onClearPressed()));
    }
    if (source.equals("CE")) {
      txtField.setText((calculator.onClearAllPressed()));
    }
  }

  private boolean isOperation(String text) {
    if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("/")) {
      return true;
    }
    return false;
  }

  private boolean isDigit(String text) {
    if (text.equals("0") || text.equals("1") || text.equals("2") || text.equals("3") ||
            text.equals("4") || text.equals("5") || text.equals("6") || text.equals("7") ||
            text.equals("8") || text.equals("9")) {
      return true;
    }
    return false;
  }

}
