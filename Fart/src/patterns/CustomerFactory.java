package patterns;

import models.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String username, String password) {
        return new Customer(username, password);
    }
}
