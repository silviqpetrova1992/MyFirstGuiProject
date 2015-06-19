package task4;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/12/15.
 */
public class ClientDemo {
  public static void main(String[] args) {
    final StringBuilder mess = new StringBuilder();
    CustomClient client = new CustomClient("localhost", 1430, new ClientDisplay() {
      @Override
      public void messageWasReceived(String message) {
        System.out.println("The received message is: "+message);
      }

      @Override
      public void unknownHost() {
        System.out.println("Don't know about this host ");
      }

      @Override
      public void serverWasDisconnected() {
        System.out.println("Couldn't get I/O for the connection to host");
      }
    });
    client.start();

  }
}
