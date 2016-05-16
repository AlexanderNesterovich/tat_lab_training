package by.training.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/16/2016.
 */
@Controller
@RequestMapping(value= "/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm() {
        logger.info("REGISTRATION");
        return "register";
    }

    @RequestMapping(value = "/form1.do", method = RequestMethod.POST)
    public String register(@RequestParam String register_username, @RequestParam String register_fullname, @RequestParam String register_email, @RequestParam String register_password, HttpSession session, Model model) {

        Customer customer = registerService.registerCustomer(register_username, register_fullname, register_email, register_password);
        logger.info("------------------------------------------");
        logger.info(customer.getFirstName());
        logger.info(customer.getLastName());
        logger.info(customer.getEmail());
        logger.info(customer.getPassword());
        logger.info("------------------------------------------");
        if (customer == null) {
            model.addAttribute("loginError", "WRONG USER OR PASSWORD");
            return "register";
        } else {
            session.setAttribute("loggedUser", customer);
            return "success";
        }

    }
    
    @RequestMapping(value = "/form2.do", method = RequestMethod.POST)
    public String login(@RequestParam String login_email, @RequestParam String login_password, @RequestParam(value = "type") String selected, HttpSession session, Model model) {
    	
    	Customer customer = loginService.loginCustomer(login_email, login_password);
    	 logger.info("------------------------------------------");
         logger.info(customer.getFirstName());
         logger.info(customer.getLastName());
         logger.info("------------------------------------------");
         logger.info(selected);
        if (customer == null) {
            model.addAttribute("loginError", "WRONG USER OR PASSWORD");
            return "register";
        } else {
            session.setAttribute("loggedUser", customer);
            return "success";
        }
    }
}
