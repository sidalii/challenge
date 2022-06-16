package wedoogift.services;

import wedoogift.helper.ServiceHelper;
import wedoogift.interfaces.ICompany;
import wedoogift.model.Company;
import wedoogift.model.Deposit;
import wedoogift.model.User;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CopmanyService implements ICompany {
    @Override
    public boolean distributeDeposits(User user, int depositId, Company company, Date distributionDate) {

        if (Objects.nonNull(depositId) && Objects.nonNull(company)) {
            List<Deposit> findDeposit = company.getDeposits().stream().filter(dep -> dep.getId() == depositId).collect(Collectors.toList());
            Deposit deposit = findDeposit.isEmpty() ? null : findDeposit.get(0);

            if (Objects.nonNull(deposit) && company.getBalance() > deposit.getAmount()) {

                // update start date of distribution
                deposit.setStartDate(distributionDate);

                //count lifeSpan and update it's value
                deposit.setLifespan(ServiceHelper.countLifeSpanOfDeposit(deposit.getStartDate(), deposit.getType()));

                //set balance value
                company.setBalance(company.getBalance() - deposit.getAmount());

                //filter deposit list in company object to remove the deposit that has been distribute
                List<Deposit> newDepositList = company.getDeposits().stream().filter(d -> d.getId() != deposit.getId()).collect(Collectors.toList());

                // set the new deposit list without  the distributed deposit
                company.setDeposits(newDepositList);

                List<Deposit> userDeposits = user.getDeposits();
                userDeposits.add(deposit);
                //set the new value of user's deposit obeject
                user.setDeposits(userDeposits);
                return true;
            }
            System.out.println("you don't have enough amount to distribute this deposit or is not available ");


        }
        return false;
    }
}