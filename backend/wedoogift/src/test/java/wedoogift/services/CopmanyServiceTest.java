package wedoogift.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import wedoogift.enums.DepositType;
import wedoogift.model.Company;
import wedoogift.model.Deposit;
import wedoogift.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CopmanyServiceTest {

    private CopmanyService copmanyService = new CopmanyService();

    @Test
    public void distributeDeposits_should_return_false_if_deposit_is_null() {
        Assertions.assertThat(copmanyService.distributeDeposits(buildUSer(), 0, buildCompany(), new Date())).isFalse();
    }

    @Test
    public void distributeDeposits_should_return_true_if_deposit_has_been_distribute_successfully() {
        Assertions.assertThat(copmanyService.distributeDeposits(buildUSer(), 1, buildCompany(), new Date())).isTrue();
    }


    private User buildUSer() {
        return new User(1, "user1", null);
    }

    private Company buildCompany() {
        return new Company(1, "wedoogift", buildValidDepositList());
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

}
