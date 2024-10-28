package DataTypes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimmy {
    public void playWithDatesAndTimes() {
        // Install java.time package. All others are obsolete or not recommended.

        LocalDate nowLocalDate = LocalDate.now();
        LocalTime nowLocalTime = LocalTime.now();
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();

        System.out.println(nowLocalDate);       // 2024-10-27
        System.out.println(nowLocalTime);       // 20:11:22.282465400
        System.out.println(nowLocalDateTime);   // 2024-10-27T20:11:22.282465400
        System.out.println(nowZonedDateTime);   // 2024-10-27T20:11:22.282465400+02:00[Europe/Sofia]

        LocalDate localDateCreated1 = LocalDate.of(2022, Month.NOVEMBER, 2);
        LocalDate localDateCreated2 = LocalDate.of(2022,11,2);
        LocalTime localTimeCreated1 = LocalTime.of(21,59);
        LocalTime localTimeCreated2 = LocalTime.of(21,50,14,145);

        System.out.println(localDateCreated1);  // 2022-11-02
        System.out.println(localDateCreated2);  // 2022-11-02
        System.out.println(localTimeCreated1);  // 21:59
        System.out.println(localTimeCreated2);  // 21:50:14.000000145

        LocalDateTime dateTimeCreated1 = LocalDateTime.of(2022,11,24,23,59,30);
        LocalDate dateCreatedToUse = LocalDate.of(2024,11,24);
        LocalTime timeCreatedToUse = LocalTime.of(23,59);
        LocalDateTime dateTimeCreated2 = LocalDateTime.of(dateCreatedToUse, timeCreatedToUse);

        ZoneId zone = ZoneId.of("Europe/Zagreb");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2022,11,2,21,50,14,0,zone);

        // just remember to subtract the offset time!
        // subtracting negative numbers is addition.
    }

    public void playWithDateAndTimeMethods() {
        // LocalDate, LocalDateTime
        // plusYears(), plusMonths(), plusWeeks(), plusDays()
        // minusYears(), minusMonths(), minusWeeks(), minusDays()

        // LocalTime, LocalDateTime
        // plusDays(), plusMinutes(), plusSeconds(), plusNanos()
        // minusDays(), minusMinutes(), minusSeconds(), minusNanos()

        // isBefore(), isAfter()

        LocalDate date = LocalDate.of(2022, Month.SEPTEMBER, 15);
        // ⚠️ Date and Time classes are immutable! Reassign to a new variable!
        var dateUpdated = date.plusDays(4).plusWeeks(1).minusYears(1);

        // ⚠️ Cannot add seconds to LocalDate!
    }

    public void playWithDateTimePeriodsDurationsAndInstants() {
        // Period => Used only for Dates
        Period period1 = Period.ofYears(2); // P2Y
        Period period2 = Period.ofMonths(3); // P3M
        Period period3 = Period.ofWeeks(1); // P7D
        Period period4 = Period.ofDays(11); // P11D
        Period period5 = Period.of(2,0,15); // P2Y15D

        LocalDate date = LocalDate.of(2022,11,20);
        date = date.plus(period1);
        date = date.minus(period2);

        // Duration => Used only for Times
        Duration duration1 = Duration.ofDays(3);     // PT72H
        Duration duration2 = Duration.ofHours(2);    // PT2H
        Duration duration3 = Duration.ofMinutes(45); // PT45M
        Duration duration4 = Duration.ofSeconds(15); // PT10S
        Duration duration5 = Duration.ofMillis(240); // PT0.24S
        Duration duration6 = Duration.ofNanos(2503); // PT0.000002503S

        // Chronounits
        // import java.time.temporal.*;
        Duration d0 = Duration.of(3, ChronoUnit.HALF_DAYS); // PT36H
        Duration d1 = Duration.of(3, ChronoUnit.DAYS);      // PT72H

        LocalTime t1 = LocalTime.of(17,30);
        LocalTime t2 = LocalTime.of(20,45);
        System.out.println(ChronoUnit.HOURS.between(t1, t2)); // 3
        System.out.println(ChronoUnit.MINUTES.between(t1, t2)); // 195

        LocalTime time = LocalTime.of(17,30);
        Duration d3 = Duration.ofMinutes(45);
        time = time.plus(d3);  // 18:15
        time = time.minus(d3); // 17:30

        // Instants
        Instant now = Instant.now();
        System.out.println(now);

        Instant before = Instant.now();
        // Do something here...
        Instant after = Instant.now();
        Duration elapsed = Duration.between(before, after);
        System.out.println(elapsed.toMillis());
        // ⚠️ Instant uses standard Java epoch (1970-01-01T00:00:00Z)!

        ZoneId id = ZoneId.of("Europe/Zagreb");
        ZonedDateTime z = ZonedDateTime.of(2022,11,2,21,50,14,15,id);
        Instant inst = z.toInstant();
        System.out.println(inst);
    }
}
