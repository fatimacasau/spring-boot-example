package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @Autowired
    PersonRepository personRepository

    @RequestMapping("/person/{id}/address")
    Address personAddress(
            @PathVariable("id") Long id
    ){
        personRepository.findOne(id).address
    }

}
