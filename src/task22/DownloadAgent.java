package task22;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgent {
  private final ProgressChangeListener listener;


  public DownloadAgent(ProgressChangeListener listener) {

    this.listener = listener;
  }

  public void download(InputStream in, OutputStream out, long length) throws Exception {
    int input;
    long numberBytes = 0;
    int percents = 0;
    listener.onDownloadStarted();
    while ((input = in.read()) != -1) {

      out.write(input);
      numberBytes++;
      if ((numberBytes * 100 / length) > percents) {
        percents++;
        listener.onProgressUpdated(percents);
      }
    }
    listener.onDownloadCompleted();
    in.close();
  }
}
