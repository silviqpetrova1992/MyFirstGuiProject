package task22;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class SampleTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  Display display;


  @Mock
  ClientMessages clientMessages;

  @Test
  public void happyPath() {

    context.checking(new Expectations() {{
      oneOf(clientMessages).clientStarted();
      will(returnValue("msg1" ));

      oneOf(clientMessages).clientWasConnected();
      will(returnValue("msg2"));

      oneOf(display).display("msg1");
      oneOf(display).display("msg2");

//      oneOf(display).displayClientStarted();
//      oneOf(display).displayConnectedToServer();
    }});

    Client client = new Client(display, clientMessages);
    client.connect();

  }
}
