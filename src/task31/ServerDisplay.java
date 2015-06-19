package task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/10/15.
 */
public interface ServerDisplay {
  public void serverWasStarted();
  public void waitingClient();
  public void acceptedClient();
  public void displaySendedMessage(String message);
  public void serverWasStoped();
  public void displayIOError();

}
