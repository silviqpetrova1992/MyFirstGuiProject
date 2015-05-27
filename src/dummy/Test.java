package dummy;

import java.io.*;

public class Test
{
  // This code is nasty and not exception safe. Just demo code!
  public static void main(String[] args) throws Exception
  {
    InputStream stream = Test.class.getResourceAsStream("/SomeTextFile.txt");
    System.out.println(stream != null);
    stream = Test.class.getClassLoader()
            .getResourceAsStream("SomeTextFile.txt");
    System.out.println(stream != null);
  }
}
