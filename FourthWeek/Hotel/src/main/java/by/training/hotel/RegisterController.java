package by.training.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/16/2016.
 */
@Controller
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        logger.info("OPEN PAGE");
        return new ModelAndView("register", "command", new Customer());

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("customer") Customer customer,
                        BindingResult result) {

        logger.info("------------------------------------------");
        logger.info(customer.getEmail());
        logger.info(customer.getPassword());
        logger.info(customer.getType());
        logger.info("------------------------------------------");
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("SpringWeb")Customer customer,
                           ModelMap model) {

        logger.info("------------------------------------------");
        logger.info(customer.getEmail());
        logger.info(customer.getPassword());
        logger.info(customer.getType());
        logger.info("------------------------------------------");
        return new ModelAndView("success");
    }
}
