package dummy;

import java.io.*;

public class Test
{
  // This code is nasty and not exception safe. Just demo code!
  public static void main(String[] args) throws Exception
  {
    InputStream stream = Test.class.getResourceAsStream("/task21/SomeTextFile.txt");
    System.out.println(stream != null);
    stream = Test.class.getClassLoader()
            .getResourceAsStream("task21/SomeTextFile.txt");
    System.out.println(stream != null);
  }
}
