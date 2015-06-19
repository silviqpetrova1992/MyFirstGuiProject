package util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 6/16/15.
 */
public class CalendarUtil {


  public static Date march(int year, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, 2);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar.getTime();
  }
}
