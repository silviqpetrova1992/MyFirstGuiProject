package task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/10/15.
 */
public class ServerDemo {
  public static void main(String[] args) {
    CustomServer customServer = new CustomServer(1430, new ServerDisplay() {
      @Override
      public void serverWasStarted() {

      }

      @Override
      public void waitingClient() {

      }

      @Override
      public void acceptedClient() {

      }

      @Override
      public void displaySendedMessage(String message) {

      }

      @Override
      public void serverWasStoped() {

      }

      @Override
      public void displayIOError() {

      }
    }, new Clock() {
      @Override
      public java.util.Date now() {
        return null;
      }
    });
    customServer.start();
  }
}
