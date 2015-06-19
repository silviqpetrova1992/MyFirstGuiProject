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
  private final ClientDisplay display;
  private String hostName;
  public String receivedMessage;

  public CustomClient(String hostName, int portNumber, ClientDisplay display) {
    this.hostName = hostName;
    this.portNumber = portNumber;
    this.display = display;
  }

  public void start() {
    try {

      Socket socket = new Socket(hostName, portNumber);
      BufferedReader in =
              new BufferedReader(
                      new InputStreamReader(socket.getInputStream()));
      while (!socket.isClosed()) {
        receivedMessage = in.readLine();
        if (receivedMessage == null) {
          display.serverWasDisconnected();
          socket.close();
          return;
        }
        display.messageWasReceived(receivedMessage);
      }
    } catch (UnknownHostException e) {
      display.unknownHost();
    } catch (IOException e) {
      display.serverWasDisconnected();
    }
  }


}