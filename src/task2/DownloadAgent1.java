package task2;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/22/15.
 */
public class DownloadAgent1 extends Thread{
  private final String urlString;
  private final String out;
  public long numberBytes = 0;
  public long length;

  public DownloadAgent1(String urlString, String out) {

    this.urlString = urlString;
    this.out = out;
  }



  @Override
  public void run() {
    try{
    URL url = new URL(urlString);
    URLConnection connection = url.openConnection();
    System.out.println(connection.getContentLength() + "\\\\\\\\\\\\\\\\");
    length = connection.getContentLength();
    InputStream in = new BufferedInputStream(
            connection.getInputStream());
    FileOutputStream output = new FileOutputStream(out);
    int inputLine;
    while ((inputLine = in.read()) != -1) {
      output.write(inputLine);
      System.out.println("iztegleni  "+numberBytes);
      numberBytes++;
    }
    in.close();
    }catch (Exception e){
      e.printStackTrace();
    }

  }
}
