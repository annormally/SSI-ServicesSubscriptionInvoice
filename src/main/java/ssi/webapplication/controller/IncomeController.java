package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.model.IncomeModel;
import ssi.webapplication.entities.IncomeEntity;
import ssi.webapplication.repositories.IncomeRepository;

// TODO: 25/01/2021 implement all method add, edit, delete and save

@Controller
public class IncomeController {

    public IncomeController() {
        System.out.println(getClass().getName() + " created.");
    }

    @Autowired
    private IncomeRepository incomeRepository;

    /**
     * Income page mapping
     */

    @GetMapping("/ssi/income")
    public ModelAndView getIncome() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/income");
        return modelAndView;
    }

    /**
     * Add income mapping
     */

    @GetMapping("/ssi/income/add")
    public ModelAndView getNewIncome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("income", new IncomeModel());
        return modelAndView;
    }

    /**
     * Edit income mapping
     */

    @GetMapping("/ssi/income/edit/{id}")
    public ModelAndView editIncome(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView(""); // complete edit page for income
        IncomeEntity incomeEntity = incomeRepository.findById(id).get();
        IncomeModel incomeModel = new IncomeModel();

        // set all fields

        return modelAndView;
    }

    /**
     * Delete income mapping
     */

    @GetMapping("/ssi/income/delete")
    public ModelAndView deleteIncome(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        incomeRepository.deleteById(id);
        return modelAndView;
    }

    /**
     * Save income mapping
     */

    @GetMapping("/ssi/income/save")
    public ModelAndView saveIncome(@ModelAttribute IncomeModel income) {
        ModelAndView modelAndView = new ModelAndView();
        IncomeEntity incomeEntity;

        // method if
        return modelAndView;
    }
}
