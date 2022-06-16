package wedoogift.services;

import org.junit.Test;
import wedoogift.enums.DepositType;
import wedoogift.model.Deposit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;


public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void calculateBalance_should_calculate_valid_deposit_balance() {

        Assertions.assertThat(userService.calculateBalance(buildValidDepositList())).isEqualTo(214);

        Assertions.assertThat(userService.calculateBalance(buildThreeValidDepositAndOneNotValidList())).isEqualTo(185);

    }


    public List<Deposit> buildValidDepositList() {

        Deposit giftDeposit = new Deposit(1, DepositType.GIFT, 40, new Date()); //valid
        Deposit giftDeposit2 = new Deposit(2, DepositType.GIFT, 45, new Date());//valid
        Deposit mealDeposit1 = new Deposit(4, DepositType.MEAL, 100, new Date());//valid
        Deposit mealDeposit2 = new Deposit(3, DepositType.MEAL, 29, new Date());//valid

        List<Deposit> depositList = new ArrayList<>();

        depositList.add(giftDeposit);
        depositList.add(giftDeposit2);
        depositList.add(mealDeposit1);
        depositList.add(mealDeposit2);
        return depositList;

    }

    public List<Deposit> buildThreeValidDepositAndOneNotValidList() {

        Deposit giftDeposit = new Deposit(1, DepositType.GIFT, 40, new Date()); //valid
        Deposit giftDeposit2 = new Deposit(2, DepositType.GIFT, 45, new Date()); //valid
        Deposit mealDeposit1 = new Deposit(4, DepositType.MEAL, 100, new Date()); // valid
        Deposit mealDeposit2 = new Deposit(3, DepositType.MEAL, 29, Date.from(Instant.parse("2021-05-09T10:15:30.00Z")));   //not valid

        List<Deposit> depositList = new ArrayList<>();

        depositList.add(giftDeposit);
        depositList.add(giftDeposit2);
        depositList.add(mealDeposit1);
        depositList.add(mealDeposit2);
        return depositList;

    }
}