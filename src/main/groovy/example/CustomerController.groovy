package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Customer findById(@PathVariable Long id) {
        customerRepository.findOne(id)
    }

}

