package task22;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/22/15.
 */
public class DownloadAgentForm implements ActionListener, ProgressChangeListener {

  DownloadAgentThread agent;
  JLabel url = new JLabel("URL:");
  JTextField urlField = new JTextField(20);
  JLabel fileName = new JLabel("File name:");
  JLabel errorLabel = new JLabel("");
  JTextField fileNameField = new JTextField(20);
  protected JButton submit = new JButton("Submit!");
  JProgressBar progressBar = new JProgressBar(0, 100);
  JPanel panel;

  public void createAndShowGUI() {
    JFrame frame = new JFrame("DownloadAgent1");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(450, 100);
    panel = new JPanel();
    addComponents(panel);
    frame.setContentPane(panel);

    //Display the window.
    frame.setVisible(true);
  }

  private static void add(JComponent name, int a, int b, int c, int d, GridBagConstraints gridBagConstraints, JPanel panel) {
    gridBagConstraints.gridx = a;
    gridBagConstraints.gridy = b;
    gridBagConstraints.gridwidth = c;
    gridBagConstraints.gridheight = d;
    panel.add(name, gridBagConstraints);
  }

  private void addComponents(JPanel panel) {
    submit.addActionListener(this);
    SpringLayout spring = new SpringLayout();
    panel.setLayout(spring);
    panel.add(url);
    panel.add(urlField);
    panel.add(fileName);
    panel.add(fileNameField);
    panel.add(submit);
    panel.add(progressBar);
    panel.add(errorLabel);
    errorLabel.setForeground(Color.RED);
    progressBar.setStringPainted(true);
    spring.putConstraint(SpringLayout.WEST, url, 45, SpringLayout.WEST, panel);
    spring.putConstraint(SpringLayout.NORTH, url, 5, SpringLayout.NORTH, panel);
    spring.putConstraint(SpringLayout.WEST, urlField, 5, SpringLayout.EAST, url);
    spring.putConstraint(SpringLayout.NORTH, urlField, 5, SpringLayout.NORTH, panel);
    spring.putConstraint(SpringLayout.NORTH, submit, 10, SpringLayout.NORTH, panel);
    spring.putConstraint(SpringLayout.WEST, submit, 15, SpringLayout.EAST, urlField);

    spring.putConstraint(SpringLayout.WEST, fileName, 5, SpringLayout.WEST, panel);
    spring.putConstraint(SpringLayout.NORTH, fileName, 5, SpringLayout.SOUTH, url);
    spring.putConstraint(SpringLayout.WEST, fileNameField, 5, SpringLayout.EAST, fileName);
    spring.putConstraint(SpringLayout.NORTH, fileNameField, 5, SpringLayout.SOUTH, urlField);
    spring.putConstraint(SpringLayout.WEST, progressBar, 100, SpringLayout.WEST, panel);
    spring.putConstraint(SpringLayout.NORTH, progressBar, 20, SpringLayout.SOUTH, fileName);
    spring.putConstraint(SpringLayout.WEST, errorLabel, 80, SpringLayout.WEST, panel);
    spring.putConstraint(SpringLayout.NORTH, errorLabel, 5, SpringLayout.SOUTH, progressBar);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    progressBar.setValue(0);
    errorLabel.setText("");
    System.out.println("Action");
    agent = new DownloadAgentThread(this.urlField.getText(), this.fileNameField.getText(), this);
    agent.start();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    if (agent.existError()) {
      errorLabel.setText(agent.getURLString());
      return;
    }
  }

  @Override
  public void onProgressUpdated(int progress) {
    progressBar.setValue(progress);
  }

  @Override
  public void onDownloadStarted() {
    submit.setEnabled(false);
    panel.setCursor((Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)));
  }

  @Override
  public void onDownloadCompleted() {
    submit.setEnabled(true);
    panel.setCursor(Cursor.getDefaultCursor());
  }
}
