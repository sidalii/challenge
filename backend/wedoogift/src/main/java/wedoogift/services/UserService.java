package wedoogift.services;

import wedoogift.helper.ServiceHelper;
import wedoogift.interfaces.IUser;
import wedoogift.model.Deposit;

import java.util.*;
import java.util.stream.Collectors;


public class UserService implements IUser {
    @Override
    public int calculateBalance(List<Deposit> userDepositList) {
        if (!userDepositList.isEmpty()) {
            List<Deposit> validDepositsList = userDepositList.stream().filter(ServiceHelper::isValidDeposit).collect(Collectors.toList());
            Integer userBalance = validDepositsList.stream().collect(Collectors.summingInt(o -> o.getAmount()));
            return userBalance;
        }
        return 0;
    }


}
