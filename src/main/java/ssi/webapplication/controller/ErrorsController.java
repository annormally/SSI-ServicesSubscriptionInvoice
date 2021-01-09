package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController {

    public ErrorsController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Error 403 (Access Denied) mapping
     *
     * @return
     */

    @GetMapping("/403")
    public ModelAndView getAccessDenied() {
        ModelAndView modelAndView = new ModelAndView("errors/403");
        return modelAndView;
    }

}
