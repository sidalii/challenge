package wedoogift.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class User {
    int id;
    String name;
    List<Deposit> deposits = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public User(int id, String name, List<Deposit> deposits) {
        this.id = id;
        this.name = name;
        if (Objects.nonNull(deposits)) {
            this.deposits = deposits;
        }
    }
}
