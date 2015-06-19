package task31;

import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class ClientUI implements ClientDisplay {
  private JFrame frame;
  private JPanel panel;
  public JTextArea field;
private CustomClient client=new CustomClient("localhost",1430,this);



  public void createAndShowGUI() {
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

  @Override
  public void clientWasStarted() {
    field.append("Starting the client...\n");
  }

  @Override
  public void clientWasConnected() {
    field.append("Conected to the server.\n");
  }

  @Override
  public void displayMessage(String message) {
    field.append("Readed message is:"+message+"\n");
  }

  @Override
  public void displayHostError() {
    field.append( "Don't know about host!\n");
  }

  @Override
  public void displayIOError() {
    field.append("Couldn't get I/O for the connection!\n");
  }
}
