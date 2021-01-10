package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/ssi/home")
    public ModelAndView getHomepage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/home");
        return modelAndView;
    }
}
