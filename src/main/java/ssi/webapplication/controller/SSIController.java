package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SSIController {

    public SSIController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Home Page mapping
     *
     * @return
     */

    @GetMapping("/ssi/homepage")
    public ModelAndView getSSIGeneralPage() {
        ModelAndView modelAndView = new ModelAndView("/main_pages/ssiHomepage");
        return modelAndView;
    }

}
