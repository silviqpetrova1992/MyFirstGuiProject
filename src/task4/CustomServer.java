package task4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class CustomServer implements ConnectionListener {
  private int port;
  private final Integer timeout;
  private final ServerDisplay display;
  private ServerSocket serverSocket;
  private int clientNumber = 0;
  private volatile int removedConnections = 0;
  private Map<Integer, ClientThread> map;

  public CustomServer(int port,Integer timeout,ServerDisplay display) throws IOException {
    this.port = port;
    this.timeout = timeout;
    this.display = display;
    serverSocket = new ServerSocket(port);
    map = new HashMap<Integer, ClientThread>();
  }

  public void start() throws IOException {

    try {
      while (true) {
        Socket clientSocket = serverSocket.accept();
        serverSocket.setSoTimeout(timeout);
        ClientThread thread;
        if (removedConnections == 0) {
          clientNumber++;
          thread = new ClientThread(clientSocket, clientNumber, this,display);
          sendMessage(display.clientIsConnected(clientNumber));
          map.put(clientNumber, thread);

        } else {
          int j = 1;
          while (map.containsKey(j)) {
            j++;
          }
          thread = new ClientThread(clientSocket, j, this,display);
          sendMessage(display.clientIsConnected(j));
          map.put(j, thread);
          removedConnections--;
        }
        display.messageWasSended();
        thread.start();
      }
    }
   catch(SocketTimeoutException ex){
      System.out.println(ex.getMessage());
      stop();
    }
    catch (Exception e) {
      display.exceptionIsCaught();
    }
  }

  private void sendMessage(String message) {
    for (ClientThread thread : map.values()) {
      thread.setOut(message);
    }
  }

  public void stop() throws IOException {
    for (ClientThread thread : map.values()) {
      thread.stopThread();
    }
    serverSocket.close();
  }

  @Override
  public void onCloseConnection(int number) {
    map.remove(number);
    sendMessage("The client # " + number + " is disconnected!");
    removedConnections++;
  }
}
