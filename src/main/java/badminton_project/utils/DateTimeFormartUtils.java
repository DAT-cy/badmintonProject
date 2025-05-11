package badminton_project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormartUtils {

    public static String formartToDateStr(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }
    public static String formartToTimeStr(Date date) {
        return new SimpleDateFormat("HHmmss").format(date);
    }

    public static String formartToDateStrWithDot(Date date) {
        return new SimpleDateFormat("yyyy.MM.dd").format(date);
    }

    public static String formartToDateTimeStr(Date date) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }
    public static Date formartToDateTime(String dateStr) throws ParseException {
        return new SimpleDateFormat("yyyyMMddHHmmss").parse(dateStr);
    }

    public static LocalDateTime formartToLocalDateTime(String dateStr) {
        if(dateStr == null || dateStr.isEmpty()) {
            return new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        }
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public static String convertDate(String inputDate) {
        DateTimeFormatter inputFormatter;
        if (inputDate.length() == 8) {
            inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        } else if (inputDate.length() == 14) {
            inputFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return date.format(outputFormatter);
    }

    public static String getCurrentDateLength14() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
    public static String convertToDateTimeFormat(String dateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDate date = LocalDate.parse(dateStr, inputFormatter);
        return date.atStartOfDay().format(outputFormatter);
    }
}
