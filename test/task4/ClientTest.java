package task4;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/8/15.
 */
public class ClientTest {
  class FakeServer {
    public void start(int portNumber, String[] messages) throws IOException {
      ServerSocket serverSocket =
              new ServerSocket(portNumber);
      Socket clientSocket = serverSocket.accept();
      PrintWriter out =
              new PrintWriter(clientSocket.getOutputStream(), true);
      for (String message : messages) {
        out.println(message);
      }
      clientSocket.close();
      serverSocket.close();
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  ClientDisplay display;


  @Test
  public void happyPath() {
    context.checking(new Expectations() {
      {
        oneOf(display).messageWasReceived("Test Message1");
        oneOf(display).messageWasReceived("Test Message2");
        oneOf(display).serverWasDisconnected();
      }
    });
    final FakeServer server = new FakeServer();
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          server.start(1430, new String[]{"Test Message1", "Test Message2"});
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    thread.start();
    CustomClient client = new CustomClient("localhost", 1430, display);
    client.start();
  }

}