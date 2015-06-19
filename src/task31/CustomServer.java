package task31;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class CustomServer implements Service{
  private int portNumber;
  private String message;
  private ServerDisplay listener;
  private final Clock clock;
  private ServerSocket serverSocket;

  public CustomServer(int portNumber, ServerDisplay listener, Clock clock) {
    this.portNumber = portNumber;
    this.listener = listener;
    this.clock = clock;
  }

  public void start() {
    listener.serverWasStarted();
    try {
      serverSocket =
              new ServerSocket(portNumber);
      listener.waitingClient();
      while (!serverSocket.isClosed()) {
        Socket clientSocket = serverSocket.accept();
        listener.acceptedClient();
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
       //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //String output = dateFormat.format(getDate());
        String output= clock.now().toString();
        listener.displaySendedMessage(output);
        out.println(output);
      }

    } catch (IOException e) {
      listener.displayIOError();
    }

  }

  public void stop() throws IOException {
    listener.serverWasStoped();
    serverSocket.close();
  }

/*
  protected Clock getDate() {
    return new Clock();
  }
*/
}
