/* *9.5 (Use the GregorianCalendar class) Java API has the
GregorianCalendar class in the java.util package, which you can
use to obtain the year, month, and day of a date. The no-arg
constructor constructs an instance for the current date, and the
methods get(GregorianCalendar.YEAR) ,
get(GregorianCalendar.MONTH) , and
get(GregorianCalendar.DAY_OF_MONTH) return the year, month, and
day. Write a program to perform two tasks:
A. Display the current year, month, and day.
B. The GregorianCalendar class has the setTimeInMillis(long) ,
which can be used to set a specified elapsed time since
January 1, 1970. Set the value to 1234567898765L and
display the year, month, and day.

*/

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class gcalendar {

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        GregorianCalendar gregcalendar = new GregorianCalendar();
        gregcalendar.setTimeInMillis(1234567898765L);
        System.out.printf("%s is the year, %s is the month, %s is the day", gregcalendar.get(Calendar.YEAR), gregcalendar.get(Calendar.MONTH), gregcalendar.get(Calendar.DAY_OF_MONTH));
    }
}