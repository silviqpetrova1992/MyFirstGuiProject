package task31;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import util.CalendarUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static util.CalendarUtil.march;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/10/15.
 */
public class ClientTest {

  class FakeServer implements Service {

    private final int port;
    private final java.util.Date date;

    FakeServer(int port, java.util.Date date) {
      this.port = port;
      this.date = date;
    }

    @Override
    public void start() {
      try {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String output = date.toString();
        out.println(output);
        clientSocket.close();
        serverSocket.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  ClientDisplay display;

  @Test
  public void happyPath() {
    final java.util.Date date= march(2015,5);
    context.checking(new Expectations() {
      {
        oneOf(display).clientWasStarted();
        oneOf(display).clientWasConnected();
        oneOf(display).displayMessage(date.toString());
      }
    });

    final FakeServer fakeServer = new FakeServer(1430,date );
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        fakeServer.start();
      }
    });
    thread.start();
    CustomClient client = new CustomClient("localhost", 1430, display);
    client.start();
  }
}

