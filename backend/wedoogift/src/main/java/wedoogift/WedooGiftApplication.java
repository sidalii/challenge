package wedoogift;

import wedoogift.datamock.DataMock;
import wedoogift.model.Company;
import wedoogift.model.User;
import wedoogift.services.CopmanyService;
import wedoogift.services.UserService;

import java.time.Instant;
import java.util.Date;

public class WedooGiftApplication {
    public static void main(String[] args) {

        DataMock dataMock = new DataMock();
        CopmanyService copmanyService = new CopmanyService();
        UserService userService = new UserService();

        // create comany
        Company company1 = new Company(1, "Appel", dataMock.getAllGiftDeposits());

        // create user
        User user1 = new User(1, "user1");


        //distribute Deposit to user with the current day date
        copmanyService.distributeDeposits(user1, 1, company1, new Date());


        //distribute invalid Deposit to user with expired date

        copmanyService.distributeDeposits(user1, 2, company1, Date.from(Instant.parse("2021-05-09T10:15:30.00Z")));


        // calculate the user's balance
        System.out.println("the user's balance = " + userService.calculateBalance(user1.getDeposits()));
    }
}
