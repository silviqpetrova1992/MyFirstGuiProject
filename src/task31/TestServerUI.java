package task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/29/15.
 */
public class TestServerUI {

  public static void main(String[] args) {
    ServerUI form = new ServerUI();
    form.createAndShowGUI();
    CustomServer server = new CustomServer(1430,form,form);
    server.start();
  }
}
