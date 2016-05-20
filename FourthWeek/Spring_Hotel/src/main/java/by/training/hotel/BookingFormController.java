package by.training.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingFormController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
    @RequestMapping(value = "/bookingform", method = RequestMethod.GET)
    public ModelAndView showBookingForm(@ModelAttribute("logged")Customer customer) {
    	logger.info("BOOKINGFORM");
    	logger.info(customer.getEmail());
        if(Singletone.loginUser(customer)) {
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject("roomsList", Singletone.getFreeRooms());
            return modelAndView;
        }
        return new ModelAndView("error");
    }

    @RequestMapping(value = "/bookingform", method = RequestMethod.POST)
    public ModelAndView book(@ModelAttribute("logged")Customer customer, @RequestParam(value="bookButton") String number) {
        logger.info("BOOKINGFORM2");
        logger.info("number booking = " + number);
        ModelAndView modelAndView = new ModelAndView("bookform");
        return modelAndView;
    }

    @RequestMapping(value = "/successfulregistration", method = RequestMethod.GET)
    public ModelAndView successfulRegistration(@ModelAttribute("logged")Customer customer) {
        logger.info("SUCCESFUL REG");
        return new ModelAndView("registered");
    }

}
