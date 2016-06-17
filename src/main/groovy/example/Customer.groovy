package example

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.UniqueConstraint
import javax.validation.constraints.NotNull

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    @NotNull
    @Column(unique = true)
    String name;

    @NotNull
    String lastName;

    @Override
    String toString() {
        "Customer[id=$id, name=$name, lastName=$lastName"
    }

}
