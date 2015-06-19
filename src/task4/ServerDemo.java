package task4;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/12/15.
 */
public class ServerDemo {
  public static void main(String[] args) throws Exception {
    CustomServer server = new CustomServer(1430,0,new ServerDisplay() {
      @Override
      public String clientIsConnected(int number) {
        return "The client # " + number + " is conected!";
      }

      @Override
      public void exceptionIsCaught() {
        System.out.println( "Exception caught when trying to listen on the port or listening for a connection");
      }

      @Override
      public String sendGreetingToClient(int number) {
        return "Hello! You are client # "+number;
      }

      @Override
      public void messageWasSended() {
      }
    });
    server.start();
  }
}
