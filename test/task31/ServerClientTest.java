package task31;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class ServerClientTest {
  List<String> messages=new ArrayList<String>();
  clientMessage clientMess =new clientMessage();
  ServerMessage serverMess=new ServerMessage();
  final CustomServer server= new CustomServer(1430, serverMess,null);
  CustomClient client= new CustomClient("localhost",1430, clientMess);
  @Test
  public void happyPath() {
   Thread thread=new Thread(new Runnable() {
     @Override
     public void run() {
       server.start();
     }
   });
    thread.start();
    client.start();
    assertThat(messages.toString(),is("Hello! 2015/06/01 06:50:30"));

  }
  @Test
  public void receivedMessages() {
    Thread thread1=new Thread(new Runnable() {
      @Override
      public void run() {
        server.start();
      }
    });
    thread1.start();
    client.start();
    assertThat(messages.toString(), is("[Starting the client..., The server is started, Waiting for a client..., Conected to the server., Accepted a client., Reading message from the server., Hello! 2015/06/01 06:50:30, The read message is: Hello! 2015/06/01 06:50:30]"));
   // server.message="STOP";
  }
class clientMessage implements ClientDisplay {


  @Override
  public void clientWasStarted() {

  }

  @Override
  public void clientWasConnected() {

  }

  @Override
  public void displayMessage(String message) {
messages.add(message);
  }

  @Override
  public void displayHostError() {

  }

  @Override
  public void displayIOError() {

  }
}
class ServerMessage implements ServerDisplay {

  @Override
  public void serverWasStarted() {

  }

  @Override
  public void waitingClient() {

  }

  @Override
  public void acceptedClient() {

  }

  @Override
  public void displaySendedMessage(String message) {

  }

  @Override
  public void serverWasStoped() {

  }

  @Override
  public void displayIOError() {

  }
}
}
