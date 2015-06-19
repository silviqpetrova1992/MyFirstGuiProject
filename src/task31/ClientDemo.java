package task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class ClientDemo {


  public static void main(String[] args) {
    CustomClient customClient = new CustomClient("localhost", 1430, null);
    customClient.start();

  }
}
