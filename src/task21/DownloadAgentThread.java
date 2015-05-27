package task21;

import task2.DownloadAgent;

import java.net.URL;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgentThread extends Thread {

  private String urlString;
  private String out;
  private task21.DownloadAgent agent;

  public DownloadAgentThread(String urlString, String out) {
    this.urlString = urlString;
    this.out = out;
  }

  public long length() {
    return agent.length;
  }

  public long numberOfBytes() {
    return agent.numberBytes;
  }

  public String getURLString() {
    return urlString;
  }

  @Override
  public void run() {
    try {
      agent = new task21.DownloadAgent();
      URL url=new URL(urlString);
      agent.download(url, out);
    } catch (Exception e) {
      agent.length = -1;
      urlString = e.getMessage();
    }
  }

  public int getPercents() {
    return agent.percents;
  }
}
