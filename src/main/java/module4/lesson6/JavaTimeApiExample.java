package module4.lesson6;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaTimeApiExample {
    public static void main(String[] args) throws InterruptedException {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime = " + dateTime);
        LocalTime time = LocalTime.now();
        System.out.println("time = " + time);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        for (; ; ) {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.print("Time is : " + dateTimeFormatter.format(LocalTime.now()) + "\r");
//        }
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println("availableZoneId = " + availableZoneId);
        }
        LocalTime.now(Clock.systemDefaultZone());
        Year now2 = Year.of(12);
        System.out.println("now2 = " + now2);
        LocalTime time1 = LocalTime.now(ZoneId.of("US/Arizona"));
        System.out.println("time1 = " + time1);
        LocalDateTime.now().isAfter(LocalDateTime.now().plusHours(1));
        System.out.println("OffsetDateTime.now() = " + OffsetDateTime.now());

    }
}
