package task3;

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
  private ServerUI form;

  public CustomServer(int portNumber, ServerUI form) {
    this.portNumber = portNumber;
    this.form = form;
    message = "";
  }

  public void start() {
    System.out.println("The server is started");
    try {
      message = "Starting the server";
      appendToTheForm(message);
      ServerSocket serverSocket =
              new ServerSocket(portNumber);
      message = "Waiting for a client...";
      appendToTheForm(message);

/*    BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));*/
  /*  String inputLine;
    while ((inputLine = in.readLine()) != null) {
      out.println(inputLine);
    }*/
      while (message!="STOP") {
        Socket clientSocket = serverSocket.accept();
        message = "Accepted a client.";
        appendToTheForm(message);
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String output = "Hello! " + dateFormat.format(date);
        appendToTheForm(output);
        out.println(output);
      }
      System.out.println("The server stop!");
      message = "Closing the server...";
      appendToTheForm(message);
      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Exception caught when trying to listen on port "
              + portNumber + " or listening for a connection");
      appendToTheForm("Exception caught when trying to listen on port or listening for a connection");
      System.out.println(e.getMessage());
    }
  }

  private void appendToTheForm(String message) {
    if (form == null) {
      return;
    }
    form.field.append(message + " \n");

  }

  public static void main(String[] args) {
    CustomServer customServer = new CustomServer(1430, null);
    customServer.start();
  }
}
