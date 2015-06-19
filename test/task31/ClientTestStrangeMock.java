package task31;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Rule;
import org.junit.Test;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/8/15.
 */
public class ClientTestStrangeMock {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery(){{
    setThreadingPolicy(new Synchroniser());
  }};;
  @Mock
  Service server;

  @Test
  public void happyPath() {
    final String[] receivedMessage = {""};
CustomClient client=new CustomClient("localhost",1430,new ClientDisplay() {
  @Override
  public void clientWasStarted() {

  }

  @Override
  public void clientWasConnected() {

  }

  @Override
  public void displayMessage(String message) {
receivedMessage[0] =message;
  }

  @Override
  public void displayHostError() {

  }

  @Override
  public void displayIOError() {

  }
});
    context.checking(new Expectations() {
      {
        oneOf(server).start();
        will(starts(1430));

      }
    });
    Thread thread=new Thread(new Runnable() {
      @Override
      public void run() {
        server.start();
      }
    });
thread.start();
    client.start();
    assertThat(receivedMessage[0],is( "Hello! 2015/06/02 06:06:06"));
  }

public static Action starts(int port){
  return new StartingServer(port);
}
}
class StartingServer implements Action {
  private final int portNumber;

  StartingServer(int portNumber) {
    this.portNumber = portNumber;
  }

  @Override
  public Object invoke(Invocation invocation) throws Throwable {
    ServerSocket serverSocket =
            new ServerSocket(portNumber);
    Socket clientSocket = serverSocket.accept();
    PrintWriter out =
            new PrintWriter(clientSocket.getOutputStream(), true);
    String output = "Hello! 2015/06/02 06:06:06";
    out.println(output);
    clientSocket.close();
    serverSocket.close();
    return null;
  }

  @Override
  public void describeTo(Description description) {
  }
}