package task31;

import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/4/15.
 */
public class ServerClientTest {
  @Test
  public void happyPath() {
    Message messageListener=new Message();
     final CustomServer server= new CustomServer(1430,messageListener){
       @Override
       public String getDate() {
         return "2015/06/01 06:50:30";
       }
     };
    CustomClient client= new CustomClient("localhost",1430,messageListener);
   Thread thread=new Thread(new Runnable() {
     @Override
     public void run() {
       server.start();
     }
   });
    thread.start();
    client.start();
    assertThat(client.receivedMessage,is("Hello! 2015/06/01 06:50:30"));
    server.message="STOP";
  }
class Message implements ProgressListener{

  @Override
  public void onMessageChanged(String message) {
    System.out.println(message);
  }
}

}
