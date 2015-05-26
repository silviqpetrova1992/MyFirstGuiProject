package examples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/21/15.
 */
  import java.net.*;
  import java.io.*;

  public class URLReader {
    public static void main(String[] args) throws Exception {

      URL oracle = new URL("http://www.addic7ed.com/updated/1/95968/0");
      System.out.println(oracle.openConnection().getInputStream().available());
      BufferedReader in = new BufferedReader(
              new InputStreamReader(oracle.openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
      in.close();
    }
  }

