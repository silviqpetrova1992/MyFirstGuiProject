package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/28/15.
 */
public class CustomClient {
  private int portNumber;
  private String hostName;
  private ClientForm form;
  public String message;
  public String receivedMessage;

  public CustomClient(String hostName, int portNumber, ClientForm form) {
    this.hostName = hostName;
    this.portNumber = portNumber;
    this.form = form;
  }

  public void start() {
    try {
      changeMessage("Starting the client...");
      Socket echoSocket = new Socket(hostName, portNumber);
      changeMessage("Conected to the client.");
     /* PrintWriter out =
              new PrintWriter(echoSocket.getOutputStream(), true);*/
      BufferedReader in =
              new BufferedReader(
                      new InputStreamReader(echoSocket.getInputStream()));
      /*BufferedReader stdIn =
              new BufferedReader(
                      new InputStreamReader(System.in));*/
      String userInput;
      // while ((userInput = stdIn.readLine()) != null) {
      //  out.println(userInput);
      changeMessage("Reading message from the client.");
      receivedMessage = in.readLine();
      System.out.println("echo: " + receivedMessage);
      changeMessage("The read message is: " + receivedMessage);
      echoSocket.close();
      // }
      changeMessage("STOP");
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      changeMessage("Don't know about host!");
      // System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " +
              hostName);
      changeMessage("Couldn't get I/O for the connection!");
      //System.exit(1);
    }
  }

  private void changeMessage(String s) {
    message = s;
    appendToTheForm(message);
  }

  private void appendToTheForm(String message) {
    if (form == null) {
      return;
    }
    form.field.append(message + " \n");

  }

  public static void main(String[] args) {
    CustomClient customClient = new CustomClient("localhost", 1430, null);
    customClient.start();

  }
}
