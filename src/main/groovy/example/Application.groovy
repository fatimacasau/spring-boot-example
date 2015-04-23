package example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        PersonRepository repository = context.getBean(PersonRepository.class);

        Person p = new Person(firstName: "Fatima",lastName: "Casau", age: 29)
        p = repository.save(p)
        println p
    }

}
