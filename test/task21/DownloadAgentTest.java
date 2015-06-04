package task21;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/26/15.
 */
public class DownloadAgentTest {
  private int[] process = new int[100];
  class Progress implements ProgressChangeListener{

    private int i=0;
    @Override
    public void onProgressUpdated(int progress) {
      process[i]=progress;
      i++;
    }
  }
  @Test
  public void happyPath() {
    final DownloadAgent agent = new DownloadAgent(new Progress());

    try {
      agent.download(DownloadAgentTest.class.getResource("/SomeTextFile.txt"), "azsisi1.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (int i=0;i<process.length;i++) {
   //  System.out.println(process[i]+"iiiii "+i);
      assertThat(process[i],is(i+1));
    }
      assertThat(new File("azsisi1.txt").length(),is(new File("txt/SomeTextFile.txt").length()));

  }
}
