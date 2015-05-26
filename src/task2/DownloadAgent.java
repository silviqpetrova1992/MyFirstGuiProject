package task2;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgent {
  public long numberBytes = 0;
  public long length;

  public void download(String urlString, String out) throws Exception {
    URL url = new URL(urlString);
    URLConnection connection = url.openConnection();
    //  URI resorce=new URI(urlString);
    // URLConnection connection=resorce.toURL().openConnection();
    System.out.println(connection.getContentLength() + "\\\\\\\\\\\\\\\\");
    length = connection.getContentLength();
    InputStream in = new BufferedInputStream(
            connection.getInputStream());
    FileOutputStream output = new FileOutputStream(out);
    int inputLine;
    while ((inputLine = in.read()) != -1) {
      output.write(inputLine);
      System.out.println("iztegleni  " + numberBytes);
      numberBytes++;
    }
    in.close();
  }
}
