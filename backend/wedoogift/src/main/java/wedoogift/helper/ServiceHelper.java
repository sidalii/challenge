package wedoogift.helper;

import wedoogift.enums.DepositType;
import wedoogift.model.Deposit;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ServiceHelper {

    public static int countLifeSpanOfDeposit(Date startDate, DepositType type) {

        if (Objects.nonNull(startDate)) {

            if (type.equals(DepositType.GIFT)) {

                return 365;

            } else if (type.equals(DepositType.MEAL)) {

                // convert startDate object to Calender
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);

                // calculate the end of February of the year following the distribution date
                LocalDate dateOfEndOfFebruaryOfTheYearFollowing
                        = Date.from(Instant.parse(calendar.get(Calendar.YEAR) + 1 + "-02-01T10:15:30.00Z")).toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                dateOfEndOfFebruaryOfTheYearFollowing = dateOfEndOfFebruaryOfTheYearFollowing.withDayOfMonth(
                        dateOfEndOfFebruaryOfTheYearFollowing.getMonth().length(dateOfEndOfFebruaryOfTheYearFollowing.isLeapYear()));


                Date dateOfEnd = Date.from(dateOfEndOfFebruaryOfTheYearFollowing.atStartOfDay(ZoneId.systemDefault()).toInstant());


                // count the diff between the start date and the end date of deposit
                long diffInMillis = Math.abs(startDate.getTime() - dateOfEnd.getTime());
                int diff = Math.round(TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS));

                return diff;

            }
        }

        return 0;
    }


    public static Boolean isValidDeposit(Deposit deposit) {

        long diffInMillis = Math.abs(deposit.getStartDate().getTime() - new Date().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return diff <= deposit.getLifespan();

    }
}
