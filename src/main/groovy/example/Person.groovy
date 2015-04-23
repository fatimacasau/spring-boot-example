package example

import javax.persistence.*
import javax.validation.constraints.*

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
