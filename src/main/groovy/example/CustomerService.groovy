package example

import org.springframework.beans.factory.annotation.Autowired


class CustomerService {

    private NotificationService notificationService
    private CustomerRepository customerRepository

    public CustomerService(NotificationService notificationService,CustomerRepository customerRepository) {
        this.notificationService = notificationService
        this.customerRepository = customerRepository
    }

    void registerCustomer(String name, String lastName) {
        Customer customer = new Customer(name:name, lastName:lastName)
        if(customerRepository.save(customer))
            notificationService.sendWelcomeMessage(customer, "Hi, welcome!")
        else {
            notificationService.sendErrorMessage(customer, "Oops, an error has ocurred!")
        }
    }

}
