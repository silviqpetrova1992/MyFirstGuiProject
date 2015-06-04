package task3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class ServerUI {
  private JFrame frame;
  private JPanel panel;
  //private JTextField field;
  private JButton btnStop;
  public JTextArea field;
  CustomServerThread server = new CustomServerThread(1430, this);



  public void createAndShowGUI() {
    this.frame = new JFrame("Server");
    this.panel = new JPanel();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    addContentToPane(panel);
    frame.setContentPane(panel);
    frame.setVisible(true);
   // server.start();
  }

  private void addContentToPane(JPanel panel) {
    SpringLayout spring = new SpringLayout();
    panel.setLayout(spring);
    btnStop = new JButton("Stop!");
    btnStop.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        server.setMessage("STOP");
        System.exit(0);
      }
    });
    field = new JTextArea(1, 20);
    JScrollPane scrollPane = new JScrollPane(field);
    field.setEnabled(false);
    field.append("Server's actions: \n");
    panel.add(field);
    panel.add(btnStop);
    spring.putConstraint(SpringLayout.WEST, field, 30, SpringLayout.WEST, panel);
    spring.putConstraint(SpringLayout.NORTH, field, 40, SpringLayout.NORTH, panel);
    spring.putConstraint(SpringLayout.EAST, btnStop, 0, SpringLayout.EAST, field);
    spring.putConstraint(SpringLayout.NORTH, btnStop, 10, SpringLayout.SOUTH, field);
    spring.putConstraint(SpringLayout.EAST, panel, 30, SpringLayout.EAST, field);


  }
}
