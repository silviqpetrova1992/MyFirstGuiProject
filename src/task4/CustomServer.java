package task4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class CustomServer {
  private int port;
  ServerSocket serverSocket;
  private int clientNumber = 0;
  Map<Integer, ClientThread> map;

  public CustomServer(int port) throws IOException {
    this.port = port;
    serverSocket = new ServerSocket(port);
    map = new HashMap<Integer, ClientThread>();
  }

  public void start() throws Exception {
    try {
      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println(clientNumber);
        clientNumber++;
        ClientThread thread = new ClientThread(clientSocket, clientNumber);
        sendMessage("The client # "+clientNumber+" is conected!");
        map.put(clientNumber, thread);
        thread.start();


      }
    } catch (IOException e) {
      System.out.println("Exception caught when trying to listen on port "
              + port + " or listening for a connection");
      System.out.println(e.getMessage());
    }
  }

  private void sendMessage(String message) {
    for (Map.Entry entry : map.entrySet()) {
      ((ClientThread) (entry.getValue())).setOut(message);
    }
  }

  public void stop() throws IOException {
    for (Map.Entry entry : map.entrySet()) {
      ((ClientThread) (entry.getValue())).interrupt();
    }
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    CustomServer server = new CustomServer(1430);
    server.start();
  }
}
