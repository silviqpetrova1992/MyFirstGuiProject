package task22;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgentThread extends Thread {

  private String urlString;
  private String out;
  private final ProgressChangeListener listener;
  private DownloadAgent agent;

  public boolean existError() {
    return error;
  }

  public String getUrlString() {
    return urlString;
  }

  private boolean error;

  public DownloadAgentThread(String urlString, String out, ProgressChangeListener listener) {
    this.urlString = urlString;
    this.out = out;
    this.listener = listener;
    error=false;
  }

  public String getURLString() {
    return urlString;
  }

  @Override
  public void run() {
    try {
      agent = new DownloadAgent(listener);
      URL url = new URL(urlString);
      URLConnection connection = url.openConnection();
      int length = connection.getContentLength();
      InputStream in = new BufferedInputStream(
              connection.getInputStream());
      FileOutputStream output = new FileOutputStream(out);
      agent.download(in, output,length);
    } catch (Exception e) {
      error=true;
      urlString = e.getMessage();
    }
  }
}
