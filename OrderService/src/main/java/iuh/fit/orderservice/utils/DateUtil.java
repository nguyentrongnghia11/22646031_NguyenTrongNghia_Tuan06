package iuh.fit.orderservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(formatter);
    }

    public static LocalDateTime parseDate(String dateString) {
        if (dateString == null) {
            return null;
        }
        return LocalDateTime.parse(dateString, formatter);
    }
}
