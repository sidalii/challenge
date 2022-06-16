package wedoogift.interfaces;

import wedoogift.model.Company;
import wedoogift.model.Deposit;
import wedoogift.model.User;

import java.util.Date;

public interface ICompany {
    boolean distributeDeposits(User user, int depositId, Company company, Date distributionDate);

}
