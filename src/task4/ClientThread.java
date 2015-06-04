package task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class ClientThread extends Thread{
  private final Socket clientSocket;
  private final int clientNumber;
  private PrintWriter out =
          null;
  private BufferedReader in= null;
  public ClientThread(Socket clientSocket, int clientNumber)throws  Exception{

    this.clientSocket = clientSocket;
    this.clientNumber = clientNumber;
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }

  public void setOut(String message) {
    out.println(message);
  }

  @Override
  public void run() {

    try {

      out.println("Hello, you are client #" + clientNumber + ".");
      while(!Thread.currentThread().isInterrupted()){
        String input=in.readLine();
        out.println(input);
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Opps");
    }

  }
}
