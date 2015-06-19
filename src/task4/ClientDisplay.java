package task4;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/12/15.
 */
public interface ClientDisplay {
  void messageWasReceived(String message);
  void unknownHost();
  void serverWasDisconnected();
}
