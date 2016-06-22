package example

import spock.lang.Specification

/**
 * Created by fatimacasau on 16/6/16.
 */
class Example6_MockingAndStubbingSpec extends Specification{

    void 'Send welcome notificacion when customer is created'() {
        given:
            // Mocking
            def mockedNotificationService = Mock(NotificationService)

            // Stubbing
            def stubbedCustomerRepository = Stub(CustomerRepository){
                save(_) >> true // customerRepository.save() method was ok
            }

            def customerService = new CustomerService(mockedNotificationService,stubbedCustomerRepository)

        when:
            customerService.registerCustomer('Fátima', 'Casau')

        then:
            1 * mockedNotificationService.sendWelcomeMessage(_, "Hi, welcome!")
           // 1 * mockedNotificationService.sendWelcomeMessage(_, "Hi, ") // This fails
            0 * mockedNotificationService.sendErrorMessage(_, _)
    }

    void 'Send error notificacion when customer is not created'() {
        given:

            // Mocking
            def mockedNotificationService = Mock(NotificationService)

            // Stubbing
            def stubbedCustomerRepository = Stub(CustomerRepository){
                save(_) >> false // customerRepository.save() method fail
            }

            def customerService = new CustomerService(mockedNotificationService,stubbedCustomerRepository)

        when:
            customerService.registerCustomer('Fátima', 'Casau')

        then:
            0 * mockedNotificationService.sendWelcomeMessage(_, "Hi, welcome!")
            1 * mockedNotificationService.sendErrorMessage(_, "Oops, an error has ocurred!")
    }



}
