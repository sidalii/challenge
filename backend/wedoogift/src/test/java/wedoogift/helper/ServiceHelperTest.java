package wedoogift.helper;


import org.junit.Test;
import wedoogift.enums.DepositType;
import wedoogift.model.Deposit;

import java.time.Instant;
import java.util.Date;

import org.assertj.core.api.Assertions;


public class ServiceHelperTest {


    @Test
    public void isValidDeposit_should_return_true_if_deposit_type_is_gift_and_lifespan_is_valid() {
        Assertions.assertThat(ServiceHelper.isValidDeposit(buildDeposit(DepositType.GIFT, new Date()))).isTrue();
    }

    @Test
    public void isValidDeposit_should_return_false_if_deposit_type_is_gift_and_lifespan_not_valid() {
        Assertions.assertThat(ServiceHelper.isValidDeposit(buildDeposit(DepositType.GIFT, Date.from(Instant.parse("2021-05-09T10:15:30.00Z"))))).isFalse();
    }


    @Test
    public void isValidDeposit_should_return_true_if_deposit_type_is_meal_and_lifespan_is_valid() {
        Assertions.assertThat(ServiceHelper.isValidDeposit(buildDeposit(DepositType.MEAL, new Date()))).isTrue();
        Assertions.assertThat(ServiceHelper.isValidDeposit(buildDeposit(DepositType.MEAL, Date.from(Instant.parse("2022-05-09T10:15:30.00Z"))))).isTrue();

    }

    @Test
    public void isValidDeposit_should_return_false_if_deposit_type_is_meal_and_lifespan_not_valid() {
        Assertions.assertThat(ServiceHelper.isValidDeposit(buildDeposit(DepositType.MEAL, Date.from(Instant.parse("2021-09-09T10:15:30.00Z"))))).isFalse();
    }


    public Deposit buildDeposit(DepositType type, Date date) {
        Deposit giftDeposit = new Deposit(1, type, 40, date);
        return giftDeposit;
    }
}