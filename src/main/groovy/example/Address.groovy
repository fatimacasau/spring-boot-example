package example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by fatimacasau on 25/04/15.
 */
@Entity
class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id
    String street
    String city
    String country

    @Override
    String toString(){
        "Address: [$street, $city, $country]"
    }
}
