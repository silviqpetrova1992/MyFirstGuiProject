package examples;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/16/15.
 */
public class GuavaExamples {
 private static Predicate<String> startsWithAB=new Predicate<String>() {
    @Override
    public boolean apply(String s) {
      return s.startsWith("ab");
    }
  };
  public static void main(String[] args) {
    List<String> stringList= Lists.newArrayList();
    stringList.add("a");
    stringList.add("ab");
    stringList.add("abv");
    stringList.add("abvg");
    stringList.add("aaa");
    stringList.add("aab");
    stringList.add("aav");

    Collection<String> anotherList= Collections2.filter(stringList,startsWithAB);
    System.out.println(anotherList);
  }
}
