package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ConfigurationProperties(prefix = "foo")
class HelloController {

    String firstProperty

    @Value("\${foo.secondProperty}")
    String secondProperty

    String getFirstProperty() {
        return firstProperty
    }

    @Autowired
    PersonRepository personRepository

    @RequestMapping("/hello")
    public String index() {
        Person p = personRepository.findAll()[0]
        return """Hello ${p.firstName}! You are in SpringIO '15!
Properties configuration: firstProperty $firstProperty, secondProperty $secondProperty
"""
    }

}
