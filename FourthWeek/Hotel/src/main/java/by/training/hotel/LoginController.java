package by.training.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Aliaksandr_Nestsiarovich on 15.05.2016.
 */
@Controller
public class LoginController {

    private LoginService loginService = new LoginService();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {

        Customer customer = loginService.loginCustomer(userId, password);
        if (customer == null) {
            model.addAttribute("loginError", "WRONG USER OR PASSWORD");
            return "login";
        } else {
            session.setAttribute("loggedUser", customer);
            return "success";
        }

    }
}
