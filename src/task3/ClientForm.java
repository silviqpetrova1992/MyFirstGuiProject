package task3;

import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class ClientForm {
  private JFrame frame;
  private JPanel panel;
  public JTextArea field;
private CustomClient client=new CustomClient("localhost",1430,this);

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ClientForm clientForm = new ClientForm();
        clientForm.createAndShowGUI();
      }
    });
  }

  private void createAndShowGUI() {
    this.frame = new JFrame("Client");
    this.panel = new JPanel();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    addContentToPane(panel);
    frame.setContentPane(panel);
    frame.setVisible(true);
    client.start();
  }

  private void addContentToPane(JPanel panel) {
    SpringLayout spring=new SpringLayout();
panel.setLayout(spring);
    field=new JTextArea(5,20);
    JScrollPane scrollPane=new JScrollPane(field);
    field.setEnabled(false);
    field.append("Client's actions: \n");

    panel.add(field);
    spring.putConstraint(SpringLayout.WEST,field,30,SpringLayout.WEST,panel);
    spring.putConstraint(SpringLayout.NORTH,field,40,SpringLayout.NORTH,panel);
    spring.putConstraint(SpringLayout.EAST,panel,30,SpringLayout.EAST,field);


  }
}
