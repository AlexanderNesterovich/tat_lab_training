package by.training.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingFormController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
    @RequestMapping(value = "/bookingform", method = RequestMethod.GET)
    public ModelAndView showBookingForm(@ModelAttribute("logged")Customer customer) {
    	logger.info("BOOKINGFORM");
    	logger.info(customer.getEmail());
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("loggedUser", customer);
        return modelAndView;

    }

}
