package example

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        // Get bean repositories
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        AddressRepository addressRepository = context.getBean(AddressRepository.class);

        // Create and save new Address
        Address address = new Address(street: "42 Wallaby Way",city: 'Sidney', country: 'Australia')
        address = addressRepository.save(address)
        println address

        // Create and save new Person
        Person person = new Person(firstName: "Fatima",lastName: "Casau", age: 29,address: address)
        person = personRepository.save(person)
        println person

        // find person with different queries
        println personRepository.findOne(1L) // Implicit query

        println personRepository.findByAgeBetween(0,30)

        println personRepository.findByFirstNameEndsWith("a")

        println personRepository.findByLastName("Casau")

        println personRepository.findByLastnameOrFirstname("","Fatima")

    }

}
