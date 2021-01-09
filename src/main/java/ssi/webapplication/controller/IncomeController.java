package ssi.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IncomeController {

    public IncomeController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Income mapping
     *
     * @return
     */

    @GetMapping("/ssi/income")
    public ModelAndView getIncome() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/income");
        return modelAndView;
    }
}
