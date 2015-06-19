package task4;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/16/15.
 */
public interface ServerDisplay {
  String clientIsConnected(int number);
  void exceptionIsCaught();
  String sendGreetingToClient(int number);
  void messageWasSended();
}
