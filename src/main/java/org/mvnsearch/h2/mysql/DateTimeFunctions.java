package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.TimeZone;

/**
 * date time functions for mysql
 *
 * @author linux_china
 */
public class DateTimeFunctions {

    /**
     * function for UNIX_TIMESTAMP
     *
     * @return current time millis
     */
    public static Long unixTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * function for UNIX_TIMESTAMP
     *
     * @return current time millis
     */
    public static Long unixTimestamp(String text) throws Exception {
        return DateUtils.parseDate(text, "YYYY-MM-DD HH:MM:SS", "YYYY-MM-DD").getTime();
    }

    public static Date fromUnixTime(Long unixTime) {
        return new Date(unixTime * 1000);
    }

    public static Date addDate(String dateText, Integer days) throws Exception {
        Date date = DateUtils.parseDate(dateText, "yyyy-MM-dd");
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
    }

    public static Date addTime(String dateText, String timeText) throws Exception {
        Date date = DateUtils.parseDate(dateText, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.S", "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
        Date time = DateUtils.parseDate(timeText, "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
        return new Date(date.getTime() + time.getTime());
    }

    public static String date(String text) throws Exception {
        Date date = DateUtils.parseDate(text, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS");
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }

    public static String utcTimestamp() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }

    public static String utcDate() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd", TimeZone.getTimeZone("UTC"));
    }

    public static String utcTime() {
        return DateFormatUtils.format(new Date(), "HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }
}
