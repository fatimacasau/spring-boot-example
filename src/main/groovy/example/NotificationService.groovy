package example


interface NotificationService {

    def sendWelcomeMessage(Customer customer, String message);

    def sendErrorMessage(Customer customer, String message);
}
