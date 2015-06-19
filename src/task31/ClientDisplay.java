package task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/29/15.
 */
interface ClientDisplay {
  void clientWasStarted();

  void clientWasConnected();

  void displayMessage(String message);

  void displayHostError();

  void displayIOError();
}
