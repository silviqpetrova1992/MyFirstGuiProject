package testpackage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/26/15.
 */
public class MyDemoClassTest {

  class PrintingService implements Service {

    private final State state;

    PrintingService(State state) {
      this.state = state;
    }

    @Override
    public void printState() {
      System.out.println("State: " + state.toString());
    }
  }

  @Test
  public void printActiveServices() {
    List<Service> services = new ArrayList<Service>() {{
      add(new PrintingService(State.ACTIVE));
      add(new PrintingService(State.UNPAID));
      add(new PrintingService(State.REACTIVATED));
    }};

    printServiceStatus(services);
  }


  private void printServiceStatus(List<Service> services) {
    for (Service service : services) {
      service.printState();
    }
  }
}
