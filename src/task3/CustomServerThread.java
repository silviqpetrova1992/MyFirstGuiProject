package task3;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/29/15.
 */
public class CustomServerThread extends Thread {
  CustomServer server;
  ServerUI form;

  public CustomServerThread(int port, ServerUI form) {
    this.form = form;
    this.server = new CustomServer(port,form);
  }
public void setMessage(String message){
server.message=message;
}
  @Override
  public void run() {
    server.start();
    String newMessage="";
    System.out.println(server.message);
    while(server.message!="STOP"){
      System.out.println("the while is running");
      if(server.message!=newMessage){
        newMessage=server.message;
        System.out.println(newMessage);
        form.field.append(server.message+ "\n");
      }
    }
  }
}
