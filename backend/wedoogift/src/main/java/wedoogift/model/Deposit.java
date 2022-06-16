package wedoogift.model;

import lombok.Getter;
import lombok.Setter;
import wedoogift.enums.DepositType;
import wedoogift.helper.ServiceHelper;

import java.util.Date;

@Getter
@Setter
public class Deposit {
    int id;
    DepositType type;
    int amount;
    int lifespan;

    Date startDate;

    public Deposit(int id, DepositType type, int amount, Date startDate) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.startDate = startDate;
        this.lifespan = ServiceHelper.countLifeSpanOfDeposit(startDate, type);
    }

    public String toString() {
        return "id  :" + id + " type :" + type + " amount:" + amount + " startDate: " + startDate + " lifeSpan :" + lifespan;
    }
}
