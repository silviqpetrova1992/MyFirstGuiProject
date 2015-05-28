package examples;

        import java.awt.GridLayout;

        import javax.swing.BorderFactory;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;

public class JavaBundleExample {

  private static void createAndShowGUI() {

    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bundle Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel(new GridLayout(0, 1));
    JButton button = new JButton("Dummy Button!");
    pane.add(button);
    JLabel label = new JLabel("Example for Bundling JRE with Java Class");
    pane.add(label);
    pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    frame.getContentPane().add(pane);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
