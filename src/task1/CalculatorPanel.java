package task1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/20/15.
 */
public class CalculatorPanel extends JPanel {
  public JTextField txtField = new JTextField();
  public PositionedButton[] buttons = new PositionedButton[]{new PositionedButton(new JButton("0"), new Point(0, 4, 2, 1)),
          new PositionedButton(new JButton("1"), new Point(0, 1, 1, 1)), new PositionedButton(new JButton("2"), new Point(1, 1, 1, 1)),
          new PositionedButton(new JButton("3"), new Point(2, 1, 1, 1)), new PositionedButton(new JButton("4"), new Point(0, 2, 1, 1)),
          new PositionedButton(new JButton("5"), new Point(1, 2, 1, 1)), new PositionedButton(new JButton("6"), new Point(2, 2, 1, 1)),
          new PositionedButton(new JButton("7"), new Point(0, 3, 1, 1)), new PositionedButton(new JButton("8"), new Point(1, 3, 1, 1)),
          new PositionedButton(new JButton("9"), new Point(2, 3, 1, 1)), new PositionedButton(new JButton("+"), new Point(3, 1, 1, 1)),
          new PositionedButton(new JButton("CE"), new Point(4, 1, 1, 1)), new PositionedButton(new JButton("-"), new Point(3, 2, 1, 1)),
          new PositionedButton(new JButton("C"), new Point(4, 2, 1, 1)), new PositionedButton(new JButton("/"), new Point(3, 3, 1, 1)),
          new PositionedButton(new JButton("="), new Point(4, 3, 1, 2)), new PositionedButton(new JButton("x"), new Point(3, 4, 1, 1)),
          new PositionedButton(new JButton("."), new Point(2, 4, 1, 1))};

  private void add(JComponent name, int a, int b, int c, int d, GridBagConstraints gridBagConstraints, JPanel panel) {
    gridBagConstraints.gridx = a;
    gridBagConstraints.gridy = b;
    gridBagConstraints.gridwidth = c;
    gridBagConstraints.gridheight = d;
    panel.add(name, gridBagConstraints);
  }

  public void addComponentsToPane() {
    //JPanel panel = new JPanel();
    GridBagLayout gb1 = new GridBagLayout();
    this.setLayout(gb1);
    //gb1.layoutContainer(frame);
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
    add(txtField, 0, 0, 5, 1, gridBagConstraints, this);

////The others lines/////////
    for (int i = 0; i < buttons.length; i++) {
      add(buttons[i].button, buttons[i].point.i, buttons[i].point.x, buttons[i].point.y, buttons[i].point.z, gridBagConstraints, this);
    }

  }
}
