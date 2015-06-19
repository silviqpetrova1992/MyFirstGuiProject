package task21;

import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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

  public void download(URL url, String out) throws Exception {
    URLConnection connection = url.openConnection();
    int length = connection.getContentLength();
    InputStream in = new BufferedInputStream(
            connection.getInputStream());
    FileOutputStream output = new FileOutputStream(out);
    int inputLine;
    long numberBytes = 0;
    int percents=0;
    while ((inputLine = in.read()) != -1) {

      output.write(inputLine);
      numberBytes++;
      if((numberBytes*100/length)>percents){
        percents++;
        listener.onProgressUpdated(percents);
      }
    }
listener.onDownloadCompleted();
    in.close();
  }
}
