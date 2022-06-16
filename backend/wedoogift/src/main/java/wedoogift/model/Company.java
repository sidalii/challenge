package wedoogift.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class Company {
    int id;
    String name;
    int balance = 0;
    List<Deposit> deposits;

    public Company(int id, String name, List<Deposit> deposits) {
        this.id = id;
        this.name = name;
        this.deposits = deposits;
        if (Objects.nonNull(deposits)) {
            this.balance = deposits.stream().collect(Collectors.summingInt(o -> o.getAmount()));
        }

    }

}
