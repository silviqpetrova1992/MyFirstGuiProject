package task31;


import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static util.CalendarUtil.march;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/10/15.
 */
public class ServerTest {
  class FakeCLient implements Service {
    private int portNumber;
    private String hostName;
    private String receivedMessage;

    Socket socket = null;


    public FakeCLient(String hostName, int portNumber) {
      this.hostName = hostName;
      this.portNumber = portNumber;
    }

    public void start() {
      try {
        socket = new Socket(hostName, portNumber);
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        receivedMessage = in.readLine();
        socket.close();
      } catch (UnknownHostException e) {
      } catch (IOException e) {
      }
    }

    public void assertReceivedMessageIs(String message) {
      assertThat(receivedMessage, is(message));
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(new Synchroniser());
  }};
  @Mock
  ServerDisplay display;
  @Mock
  Clock clock;

  @Test
  public void happyPath() {

    final Date firstOrMarch = march(2015,1);
    context.checking(new Expectations() {
      {
        ignoring(display);
        oneOf(clock).now();
        will(returnValue(firstOrMarch));
      }
    });
    final CustomServer server = new CustomServer(1430, display, clock);

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        server.start();
      }
    });
    thread.start();
    FakeCLient fakeCLient = new FakeCLient("localhost", 1430);
    fakeCLient.start();
    fakeCLient.assertReceivedMessageIs(firstOrMarch.toString());

  }
}

