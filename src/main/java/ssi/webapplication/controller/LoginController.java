package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginController {

    public LoginController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Login mapping
     *
     * @return
     */

    @GetMapping("/")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPageWithLogin() {
        ModelAndView modelAndView = new ModelAndView("main_pages/login");
        return modelAndView;
    }

    /**
     * Display username
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public String currentUsername(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
}
