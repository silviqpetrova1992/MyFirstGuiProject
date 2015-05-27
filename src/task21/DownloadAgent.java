package task21;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgent {
  public long numberBytes = 0;
  public long length;
  public int percents=0;

  public void download(URL url, String out) throws Exception {
   // URL url = new URL(urlString);
    URLConnection connection = url.openConnection();
    System.out.println(connection.getContentLength() + "\\\\\\\\\\\\\\\\");
    length = connection.getContentLength();
    InputStream in = new BufferedInputStream(
            connection.getInputStream());
    FileOutputStream output = new FileOutputStream(out);
    int inputLine;
    while ((inputLine = in.read()) != -1) {
      if((numberBytes*100/length)>percents){
        percents++;
      }
      output.write(inputLine);
      System.out.println("iztegleni  " + numberBytes+ "Procenti  "+percents);
      numberBytes++;
    }
    percents=100;
    in.close();
  }
}
