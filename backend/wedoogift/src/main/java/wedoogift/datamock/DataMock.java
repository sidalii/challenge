package wedoogift.datamock;

import wedoogift.enums.DepositType;
import wedoogift.model.Deposit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataMock {

    Deposit giftDeposit = new Deposit(1, DepositType.GIFT, 40, new Date());
    Deposit giftDeposit2 = new Deposit(2, DepositType.GIFT, 45, new Date());
    Deposit giftDeposit3 = new Deposit(3, DepositType.GIFT, 29, new Date());
    Deposit mealDeposit = new Deposit(4, DepositType.MEAL, 100, new Date());
    Deposit mealDeposit2 = new Deposit(5, DepositType.MEAL, 50, new Date());
    Deposit mealDeposit3 = new Deposit(6, DepositType.MEAL, 40, new Date());

    public List<Deposit> getAllDepositsType() {
        List<Deposit> depositList = new ArrayList<>();

        depositList.add(giftDeposit);
        depositList.add(giftDeposit2);
        depositList.add(giftDeposit3);
        depositList.add(mealDeposit);
        depositList.add(mealDeposit2);
        depositList.add(mealDeposit3);

        return depositList;
    }

    public List<Deposit> getAllGiftDeposits() {
        List<Deposit> depositList = new ArrayList<>();

        depositList.add(giftDeposit);
        depositList.add(giftDeposit2);
        depositList.add(giftDeposit3);
        return depositList;
    }

    public List<Deposit> getAllMealDeposits() {
        List<Deposit> depositList = new ArrayList<>();
        depositList.add(mealDeposit);
        depositList.add(mealDeposit2);
        depositList.add(mealDeposit3);

        return depositList;
    }


}
