package task22;

import com.google.common.io.ByteStreams;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.google.common.io.ByteStreams.toByteArray;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/8/15.
 */
public class AnotherDownloadAgentTest {
  Listener listener = new Listener();
  DownloadAgent agent = new DownloadAgent(listener);
  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void happyPath() throws Exception {
    File createdFile = folder.newFile("Testing.txt");
    OutputStream out = new FileOutputStream(createdFile);
    InputStream in = AnotherDownloadAgentTest.class.getResourceAsStream("ForTesting.txt");
    Path file = Paths.get(AnotherDownloadAgentTest.class.getResource("ForTesting.txt").getFile());
    agent.download(in, out, file.toFile().length());
    listener.checkProgress();
    String inputContent = new String(ByteStreams.toByteArray(AnotherDownloadAgentTest.class.getResourceAsStream("ForTesting.txt")));
    String receivedContent = new String(toByteArray(new FileInputStream(createdFile)));
    assertThat(inputContent, is(equalTo(receivedContent)));

  }

  class Listener implements ProgressChangeListener {
    private int i = 0;
    private int[] process = new int[100];

    @Override
    public void onProgressUpdated(int progress) {
      process[i] = progress;
      i++;
    }

    @Override
    public void onDownloadStarted() {

    }

    @Override
    public void onDownloadCompleted() {

    }

    public void checkProgress() {
      for (int i = 0; i < process.length; i++) {
        assertThat(process[i], is(i + 1));
      }
    }
  }
}
