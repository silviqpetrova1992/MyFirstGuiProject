package task31;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class CustomServer {
  private int portNumber;
  public String message;
private ProgressListener listener;

  public CustomServer(int portNumber, ProgressListener listener) {
    this.portNumber = portNumber;
    this.listener = listener;
    message = "";
  }

  public void start() {
    listener.onMessageChanged("The server is started");
    try {
      ServerSocket serverSocket =
              new ServerSocket(portNumber);
      listener.onMessageChanged("Waiting for a client...");

/*    BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));*/

      while (message!="STOP") {
        Socket clientSocket = serverSocket.accept();
        listener.onMessageChanged("Accepted a client.");
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String output = "Hello! " + getDate();
        listener.onMessageChanged(output);
        out.println(output);
      }
      listener.onMessageChanged("Closing the server...");
      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Exception caught when trying to listen on port "
              + portNumber + " or listening for a connection");
      listener.onMessageChanged("Exception caught when trying to listen on port or listening for a connection");
      System.out.println(e.getMessage());
    }
  }
public  String getDate(){
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Date date = new Date();
  return dateFormat.format(date);
}
  public static void main(String[] args) {
    CustomServer customServer = new CustomServer(1430, null);
    customServer.start();
  }
}
