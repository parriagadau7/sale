package cl.transbank.sale.domain.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateUtil {

    private static LocalDate date = LocalDate.now();
    private static LocalTime startTime = LocalTime.of(00, 00);
    private static LocalTime endTime = LocalTime.of(23, 59, 59);

    public static LocalDateTime getStartDateTime(){
        return LocalDateTime.of(date, startTime);
    }

    public static LocalDateTime getEndDateTime(){
        return LocalDateTime.of(date, endTime);
    }
}
