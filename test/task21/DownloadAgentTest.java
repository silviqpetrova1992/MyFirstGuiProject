package task21;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/26/15.
 */
public class DownloadAgentTest {
  @Test
  public void happyPath() {
    final DownloadAgent agent = new DownloadAgent();
    final int[] process = new int[101];
    Thread counter = new Thread(new Runnable() {
      @Override
      public void run() {
        int i = 0;
        int procent;
        while (i < 100) {
         System.out.println(agent.percents+"---"+i);
          procent=agent.percents;
          if (procent > i) {
            System.out.println("zapisvame "+procent);
            process[procent] = procent;
            i =procent;
          }
        }
      }
    });
    counter.setPriority(Thread.MAX_PRIORITY);
    counter.start();
    try {
      agent.download(DownloadAgentTest.class.getResource("/SomeTextFile.txt"), "azsisi1.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (int i=0;i<process.length;i++) {
    //  System.out.println(process[i]+"iiiii "+i);
      assertThat(process[i],is(i));
    }
      assertThat(new File("azsisi1.txt").length(),is(new File("txt/SomeTextFile.txt").length()));

  }
}
