package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public class HelloController {

    @Autowired
    PersonRepository personRepository

    @RequestMapping("/")
    public String index() {
        Person p = personRepository.findAll()[0]
        return "Hello ${p.firstName}! You are in SpringIO '15!";
    }

}
