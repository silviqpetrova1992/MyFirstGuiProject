package task21;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/3/15.
 */
public class AppDemo {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        DownloadAgentForm agent = new DownloadAgentForm();
        agent.createAndShowGUI();
      }
    });
  }
}
