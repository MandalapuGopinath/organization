package com.organization.account.util;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date calculateFromDate(String type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if ("Monthly".equalsIgnoreCase(type) || "Y".equalsIgnoreCase(type)) {
            // For Monthly or Y type, calculate fromDate as current month - 3 months
            calendar.add(Calendar.MONTH, -3);
            calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the first day of the month
        } else {
            // For specific month name
            switch (type.toLowerCase()) {
                case "january":
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    break;
                case "february":
                    calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
                    break;
                case "march":
                    calendar.set(Calendar.MONTH, Calendar.MARCH);
                    break;
                case "april":
                    calendar.set(Calendar.MONTH, Calendar.APRIL);
                    break;
                case "may":
                    calendar.set(Calendar.MONTH, Calendar.MAY);
                    break;
                case "june":
                    calendar.set(Calendar.MONTH, Calendar.JUNE);
                    break;
                case "july":
                    calendar.set(Calendar.MONTH, Calendar.JULY);
                    break;
                case "august":
                    calendar.set(Calendar.MONTH, Calendar.AUGUST);
                    break;
                case "september":
                    calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
                    break;
                case "october":
                    calendar.set(Calendar.MONTH, Calendar.OCTOBER);
                    break;
                case "november":
                    calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
                    break;
                case "december":
                    calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid month name: " + type);
            }
            calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the first day of the selected month
        }

        // Set time to start of the day (midnight)
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
