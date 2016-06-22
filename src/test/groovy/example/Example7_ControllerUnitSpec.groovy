package example

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


class Example7_ControllerUnitSpec extends Specification{

    // Mocking services
    def customerRepository = Mock(CustomerRepository)

    // Init controller with mock:
    def @Subject controller = new CustomerController(customerRepository: customerRepository)

    // Let Spring MVC Test process the controller:
    def mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

    def 'should call rest controller'() {
        when:

            // Try different URL or Method to see what will happen!
            def resultRestCall = mockMvc.perform(get('/customer/1'))

        then:
            // Expect 1 call to repository to get users:
            1 * customerRepository.findOne(_) >> new Customer(id:1, name:"Fatima", lastName: "Casau")
            resultRestCall.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            //    .andExpect(content().string('{"id":1,"name":"Fatima","lastName":"Casau"')) // This fails
    }
}
