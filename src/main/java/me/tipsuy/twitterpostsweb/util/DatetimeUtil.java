package me.tipsuy.twitterpostsweb.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Daniel Baharian
 * @since 10 oct. 2021
 */
public class DatetimeUtil {

   private DatetimeUtil() {
   }

   public static int dateNow() {
      final var now = new Date();
      final var sdf = new SimpleDateFormat("yyyyMMdd");
      return Integer.parseInt(sdf.format(now));
   }

   public static int timeNow() {
      final var now = new Date();
      final var sdf = new SimpleDateFormat("HHmmss");
      return Integer.parseInt(sdf.format(now));
   }

   public static LocalDate convertToLocalDate(int date) {
      final var dateStr = Integer.toString(date);
      return LocalDate.of(Integer.parseInt(dateStr.substring(0, 4)), Integer.parseInt(dateStr.substring(4, 6)),
            Integer.parseInt(dateStr.substring(6)));
   }

   public static String convertDateToString(int date, char separator) {
      final var localDate = convertToLocalDate(date);
      return new StringBuilder(Integer.toString(localDate.getDayOfMonth()))
            .append(separator)
            .append(localDate.getMonth())
            .append(separator)
            .append(localDate.getYear())
            .toString();
   }

   public static LocalTime convertToLocalTime(int time) {
      final var timeStr = StringUtils.leftPad(Integer.toString(time), 6, '0');
      return LocalTime.of(Integer.parseInt(timeStr.substring(0, 2)), Integer.parseInt(timeStr.substring(2, 4)),
            Integer.parseInt(timeStr.substring(4)));
   }

   public static String convertTimeToString(int time) {
      final var localTime = convertToLocalTime(time);
      return new StringBuilder(Integer.toString(localTime.getHour())).append(":").append(localTime.getHour()).toString();
   }

   public static int getDateFromXMLGregorianCalendar(XMLGregorianCalendar xmlGregorianCalendar) {
      final var day = xmlGregorianCalendar.getDay();
      final var year = xmlGregorianCalendar.getYear();
      final var month = xmlGregorianCalendar.getMonth();
      return year * 10000 + month * 100 + day;
   }

   public static int getTimeFromXMLGregorianCalendar(XMLGregorianCalendar xmlGregorianCalendar) {
      final var sec = xmlGregorianCalendar.getSecond();
      final var min = xmlGregorianCalendar.getMinute();
      final var hour = xmlGregorianCalendar.getHour();
      return hour * 10000 + min * 100 + sec;
   }
}
