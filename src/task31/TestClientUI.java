package task31;

import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class TestClientUI {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ClientUI clientForm = new ClientUI();
        clientForm.createAndShowGUI();
      }
    });
  }
}
