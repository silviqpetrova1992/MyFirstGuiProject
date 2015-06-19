package task4;

import org.jmock.Expectations;
import org.jmock.States;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class ServerTest {
  class Client {
    private final String hostName;
    private final int portNumber;
    private StringBuilder messages = new StringBuilder();

    Client(String hostname, int portNumber) {
      this.hostName = hostname;
      this.portNumber = portNumber;
    }

    public void start() throws IOException {
      Socket socket = new Socket(hostName, portNumber);


      InputStream in = socket.getInputStream();

      byte[] buffer = new byte[1024];
      int read;

      while ((read = in.read(buffer)) != -1) {
        String receivedMessage = new String(buffer, 0, read - 1);
        messages.append(receivedMessage);      
      }

      socket.close();
    }

    public synchronized void assertReceivedMessages(String expectedMessages) {
      assertThat(this.messages.toString(), is(expectedMessages));
    }
  }

  CustomServer server;
  Thread serverThread;
  Synchroniser synchroniser = new Synchroniser();
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(synchroniser);
  }};
  @Mock
  ServerDisplay display;

  @Test
  public void happyPath() throws IOException, InterruptedException {
    final States continuing = context.states("state").startsAs("false");
    context.checking(new Expectations() {
      {
        oneOf(display).sendGreetingToClient(1);
        will(returnValue("Hello! You are client #1!"));
        oneOf(display).clientIsConnected(1);
        will(returnValue("The client # 1 is connected!"));
        oneOf(display).messageWasSended();
        then(continuing.is("true"));
        oneOf(display).sendGreetingToClient(2);
       // when(continuing.is("true"));
        will(returnValue("Hello! You are client #2!"));
        oneOf(display).clientIsConnected(2);
        will(returnValue("The client # 2 is connected!"));
        oneOf(display).messageWasSended();
       then(continuing.is("allowTheAssert"));
      }
    });
    server = new CustomServer(1430, 0, display);
    startServer();
    final Client client1 = new Client("localhost", 1430);
    final Client client2 = new Client("localhost", 1430);

    connect(client1);
    //  Thread.sleep(100);
    synchroniser.waitUntil(continuing.is("true"));
    connect(client2);
    synchroniser.waitUntil(continuing.is("allowTheAssert"));
    // serverThread.join();
    client1.assertReceivedMessages("Hello! You are client #1!The client # 2 is connected!");
    client2.assertReceivedMessages("Hello! You are client #2!");
  }

  private void startServer() {
    serverThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          server.start();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    serverThread.start();
  }

  private void connect(final Client client) {
    Thread client1Thrread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          client.start();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    client1Thrread.start();
  }
}

