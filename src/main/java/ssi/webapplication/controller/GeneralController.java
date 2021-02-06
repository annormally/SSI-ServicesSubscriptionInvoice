package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    /**
     * Contact page mapping
     *
     * @return
     */

    @GetMapping("/ssi/contact")
    public ModelAndView getContactPage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/contact");
        return modelAndView;
    }

    /**
     * About page mapping
     *
     * @return
     */

    @GetMapping("/ssi/about")
    public ModelAndView getAboutPage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/about");
        return modelAndView;
    }
}