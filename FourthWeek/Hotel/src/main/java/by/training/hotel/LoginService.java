package by.training.hotel;

import org.springframework.stereotype.Service;

/**
 * Created by Aliaksandr_Nestsiarovich on 15.05.2016.
 */
@Service
public class LoginService {

    public Customer loginCustomer(String userId, String password) {
        if (userId.equals("top") && password.equals("kek")) {
            Customer tmp = new Customer();
            return tmp;
        }
        return null;
    }
}
