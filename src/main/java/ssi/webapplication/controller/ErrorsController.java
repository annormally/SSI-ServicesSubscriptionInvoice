package ssi.webapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorsController implements ErrorController {

    public static Logger logger = LoggerFactory.getLogger(ErrorsController.class);

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

    @GetMapping("/404")
    public ModelAndView getNotFoundPage() {
        ModelAndView modelAndView = new ModelAndView("errors/404");
        return modelAndView;
    }

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            return new ModelAndView("error/403");
        }

        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
