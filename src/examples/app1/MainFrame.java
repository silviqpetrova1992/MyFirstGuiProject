package examples.app1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/15/15.
 */
public class MainFrame extends JFrame {
  public MainFrame(String title){
    super(title);
    setLayout(new BorderLayout());
    final JTextArea textArea=new JTextArea();
    JButton button=new JButton("Click me!");
    Container c=getContentPane();
    c.add(textArea,BorderLayout.CENTER);
    c.add(button,BorderLayout.SOUTH);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textArea.append("Hello\n");
      }
    });
  }
}
