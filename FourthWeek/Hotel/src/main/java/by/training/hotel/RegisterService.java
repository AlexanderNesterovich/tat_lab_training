package by.training.hotel;

import org.springframework.stereotype.Service;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/16/2016.
 */
@Service
public class RegisterService {

    public Customer registerCustomer(String name, String name2, String email, String password) {
        if (name.equals("dick")) {
            return null;
        }
        Customer tmp = new Customer();
        tmp.setId("1");
        tmp.setEmail(email);
        tmp.setPassword(password);
        return tmp;
    }
}
