package by.training.hotel;

/**
 * Created by Aliaksandr_Nestsiarovich on 15.05.2016.
 */
public class LoginService {

    public Customer loginCustomer(String userId, String password) {
        if (userId.equals("top") && password.equals("kek")) {
            Customer tmp = new Customer();
            tmp.setId("1");
            tmp.setName("Vova");
            tmp.setSurname("kek");
            return tmp;
        }
        return null;
    }
}
