package task22;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class Client {
  private final Display display;
  private final ClientMessages clientMessages;

  public Client(Display display, ClientMessages clientMessages) {

    this.display = display;
    this.clientMessages = clientMessages;
  }

  public void connect() {

//    display.displayClientStarted();
//    display.displayConnectedToServer();

    display.display(clientMessages.clientStarted());
    display.display(clientMessages.clientWasConnected());
  }
}
