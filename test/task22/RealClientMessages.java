package task22;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/9/15.
 */
public class RealClientMessages implements ClientMessages {
  @Override
  public String clientStarted() {
    return "FakeCLient was started.";
  }

  @Override
  public String clientWasConnected() {
    return "FakeCLient was connected to the server.";
  }
}
