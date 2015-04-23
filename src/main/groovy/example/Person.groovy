package example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by fcasau on 4/23/15.
 */
@Entity
class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id

    @NotNull
    @Size(max = 20)
    String firstName

    @Size(max = 50)
    String lastName

    @Max(100L)
    Integer age

    @Override
    String toString(){
        "Person: [Name: $firstName, LastName: $lastName, Age: $age]"
    }
}
