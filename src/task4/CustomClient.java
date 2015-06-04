package task4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class CustomClient {
  private int portNumber;
  private String hostName;
  public String receivedMessage;

  public CustomClient(String hostName, int portNumber) {
    this.hostName = hostName;
    this.portNumber = portNumber;
    // this.listener = listener;
  }

  public void start() {
    try {
      //listener.onMessageChanged("Starting the client...");
      Socket echoSocket = new Socket(hostName, portNumber);
      // listener.onMessageChanged("Conected to the server.");
     /* PrintWriter out =
              new PrintWriter(echoSocket.getOutputStream(), true);*/
      BufferedReader in =
              new BufferedReader(
                      new InputStreamReader(echoSocket.getInputStream()));
      // listener.onMessageChanged("Reading message from the server.");
      while (!echoSocket.isClosed()) {
        receivedMessage = in.readLine();

        if (receivedMessage == null || receivedMessage.equals("null")) {
          echoSocket.close();
          System.exit(0);
        }
        System.out.println("server: " + receivedMessage);
      }
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      // listener.onMessageChanged("Don't know about host!");
      // System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " +
              hostName);
      // listener.onMessageChanged("Couldn't get I/O for the connection!");
      //System.exit(1);
    }
  }

  public static void main(String[] args) {
    CustomClient client = new CustomClient("localhost", 1430);
    client.start();
  }
}