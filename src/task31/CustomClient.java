package task31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class CustomClient implements CustomClientIntf {
  private int portNumber;
  private String hostName;
  private String receivedMessage;
  private ClientDisplay listener;

  Socket socket = null;


  public CustomClient(String hostName, int portNumber, ClientDisplay listener) {
    this.hostName = hostName;
    this.portNumber = portNumber;
    this.listener = listener;
  }

  public void start() {
    try {
      listener.clientWasStarted();
      conect(hostName, portNumber);
      listener.clientWasConnected();


      operateWithMessage();


      listener.displayMessage(receivedMessage);
      socket.close();
    } catch (UnknownHostException e) {
      listener.displayHostError();
    } catch (IOException e) {
      listener.displayIOError();
    }
  }

  public boolean conect(String hostName, int port) throws IOException {
    socket = new Socket(hostName, portNumber);
    return true;
  }

  public String operateWithMessage() throws IOException {
    BufferedReader in =
            new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
    return receivedMessage = in.readLine();
  }

}
