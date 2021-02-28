package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Mapping for "home" page.
     *
     * @return
     */

    @GetMapping("/ssi/home")
    public ModelAndView getHomepage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/home");

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }
}
