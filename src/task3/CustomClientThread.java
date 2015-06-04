package task3;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/29/15.
 */
public class CustomClientThread extends Thread{
  CustomClient client;
  ClientForm form;

  public CustomClientThread(int port,ClientForm form) {
    this.form = form;
    this.client = new CustomClient("localhost",port,form);
  }
  public void setMessage(String message){
    client.message=message;
  }
  @Override
  public void run() {
    client.start();
    String newMessage="";
    System.out.println(client.message);
    while(client.message!="STOP"){
      System.out.println("the while is running");
      if(client.message!=newMessage){
        newMessage= client.message;
        System.out.println(newMessage);
        form.field.append(client.message+ "\n");
      }
    }
  }
}
