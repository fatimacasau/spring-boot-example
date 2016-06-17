package example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);


        CustomerRepository customerRepository = context.getBean(CustomerRepository.class)

        def c = customerRepository.save(new Customer(name:"a",lastName: "b"))
        println c
    }


}
