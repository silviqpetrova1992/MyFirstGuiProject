package task31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class CustomClient {
  private int portNumber;
  private String hostName;
private ProgressListener listener;
  public String receivedMessage;

  public CustomClient(String hostName, int portNumber, ProgressListener listener) {
    this.hostName = hostName;
    this.portNumber = portNumber;
    this.listener = listener;
  }

  public void start() {
    try {
      listener.onMessageChanged("Starting the client...");
      Socket echoSocket = new Socket(hostName, portNumber);
      listener.onMessageChanged("Conected to the server.");
     /* PrintWriter out =
              new PrintWriter(echoSocket.getOutputStream(), true);*/
      BufferedReader in =
              new BufferedReader(
                      new InputStreamReader(echoSocket.getInputStream()));
      listener.onMessageChanged("Reading message from the server.");
      receivedMessage = in.readLine();
      System.out.println("echo: " + receivedMessage);
      listener.onMessageChanged("The read message is: " + receivedMessage);
      echoSocket.close();
      // }
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      listener.onMessageChanged("Don't know about host!");
      // System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " +
              hostName);
     listener.onMessageChanged("Couldn't get I/O for the connection!");
      //System.exit(1);
    }
  }


  public static void main(String[] args) {
    CustomClient customClient = new CustomClient("localhost", 1430, null);
    customClient.start();

  }
}
