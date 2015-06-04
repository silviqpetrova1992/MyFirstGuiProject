package task21;


import java.net.URL;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgentThread extends Thread {

  private String urlString;
  private String out;
  private final ProgressChangeListener listener;
  private task21.DownloadAgent agent;

  public DownloadAgentThread(String urlString, String out, ProgressChangeListener listener) {
    this.urlString = urlString;
    this.out = out;
    this.listener = listener;
  }

  public String getURLString() {
    return urlString;
  }

  @Override
  public void run() {
    try {
      agent = new task21.DownloadAgent(listener);
      URL url = new URL(urlString);
      agent.download(url, out);
    } catch (Exception e) {
      // agent.length = -1;
      urlString = e.getMessage();
    }
  }

  public int getPercents() {
    //return agent.percents;
    return 0;
  }
}
