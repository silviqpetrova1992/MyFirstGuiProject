package examples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/21/15.
 */
  import java.net.*;
  import java.io.*;

  public class URLReader {
    public static void main(String[] args) throws Exception {

      URL oracle = new URL("http://www.oracle.com/");
      BufferedReader in = new BufferedReader(
              new InputStreamReader(oracle.openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
      in.close();
    }
  }

