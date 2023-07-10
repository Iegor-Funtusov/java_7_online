package ua.com.alevel;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateMain {

    public static void main(String[] args) {
        System.out.println("Hello DateMain!");

        Date date = new Date();
//        Date date = new Date(1688939025032L);
//        Date date = new Date(Long.MAX_VALUE);
        System.out.println("date = " + date);

        long start = System.currentTimeMillis() - 68400000;
        System.out.println("start = " + start);


        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        TimeZone timeZone = calendar.getTimeZone();
        System.out.println("timeZone = " + timeZone.getRawOffset());

        TimeZone timeZone1 = TimeZone.getTimeZone("America/Mexico_City");
        System.out.println("timeZone1 = " + timeZone1);
        Calendar calendar1 = Calendar.getInstance(timeZone1);
        System.out.println("calendar1 = " + calendar1);

        TimeZone timeZoneUA = TimeZone.getTimeZone("Europe/Kiev");
        Calendar calendarUA = Calendar.getInstance(timeZoneUA);
        calendarUA.set(2023, Calendar.JULY, 11, 16, 45, 0);
        System.out.println("calendarUA = " + calendarUA.getTime());

        int weekYear = calendarUA.getWeekYear();
        System.out.println("weekYear = " + weekYear);
        int dayMonth = calendarUA.get(Calendar.DAY_OF_MONTH);
        int dayWeek = calendarUA.get(Calendar.DAY_OF_WEEK);
        int hour = calendarUA.get(Calendar.HOUR);
        int minute = calendarUA.get(Calendar.MINUTE);
        System.out.println("dayMonth = " + dayMonth);
        System.out.println("dayWeek = " + dayWeek);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);

        boolean before = calendarUA.before(calendar);
        boolean after = calendarUA.after(calendar);
        System.out.println("before = " + before);
        System.out.println("after = " + after);

        calendarUA.add(Calendar.HOUR, -2);
        System.out.println("calendarUA = " + calendarUA.getTime());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
    }
}
