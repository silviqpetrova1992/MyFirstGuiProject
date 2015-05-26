package task2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/22/15.
 */
public class Demo {
  public static void main(String[] args) throws Exception {
    DownloadAgent downloadAgent=new DownloadAgent();
downloadAgent.download("http://www.oracle.com/","sistextfile.txt");
  }

}
