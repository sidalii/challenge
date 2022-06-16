package wedoogift.interfaces;

import wedoogift.model.Deposit;

import java.util.List;

public interface IUser {

    int calculateBalance(List<Deposit> userDepositList);
}
