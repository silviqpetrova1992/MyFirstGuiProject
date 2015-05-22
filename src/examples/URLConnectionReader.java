package examples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/21/15.
 */
import java.net.*;
import java.io.*;

public class URLConnectionReader {
  public static void main(String[] args) throws Exception {
    URL oracle = new URL("http://www.oracle.com/");
    URLConnection yc = oracle.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(
            yc.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);
    in.close();
  }
}
