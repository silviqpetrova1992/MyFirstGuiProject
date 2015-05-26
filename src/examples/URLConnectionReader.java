package examples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/21/15.
 */
import java.net.*;
import java.io.*;

public class URLConnectionReader {
  public static void main(String[] args) throws Exception {
    URL oracle = new URL("http://i.dir.bg/r2015/technopolis/TVSamsung_new.png");
    URLConnection yc = oracle.openConnection();
    System.out.println(yc.getContentLength());
    BufferedReader in = new BufferedReader(new InputStreamReader(
            yc.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);
    in.close();
  }
}
