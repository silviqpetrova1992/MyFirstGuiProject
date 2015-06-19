package task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class ClientThread extends Thread{
  private final Socket clientSocket;
  private final int clientNumber;
  private final ConnectionListener listener;
  private final ServerDisplay display;
  private PrintWriter out =
          null;
  private BufferedReader in= null;
  public ClientThread(Socket clientSocket, int clientNumber,ConnectionListener listener,ServerDisplay display)throws  Exception{

    this.clientSocket = clientSocket;
    this.clientNumber = clientNumber;
    this.listener = listener;
    this.display = display;
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }

  public void setOut(String message) {
    out.println(message);
  }

  @Override
  public void run() {
      out.println(display.sendGreetingToClient(clientNumber));

    try {
      while(in.read()!=-1){

      }
    } catch (SocketException exc){
      System.out.println(exc.getMessage()+ clientNumber);
    } catch (IOException e) {
      e.printStackTrace();
    }
    listener.onCloseConnection(clientNumber);

  }
  public void stopThread() throws IOException {
    this.interrupt();
    clientSocket.close();

  }
}
