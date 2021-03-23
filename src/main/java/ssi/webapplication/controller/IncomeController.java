package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.model.IncomeModel;
import ssi.webapplication.entities.IncomeEntity;
import ssi.webapplication.repositories.IncomeRepository;
import ssi.webapplication.repositories.UserRepository;


@Controller
public class IncomeController {

    public IncomeController() {
        System.out.println(getClass().getName() + " created.");
    }

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Income page mapping
     *
     * @return
     */

    @GetMapping("/ssi/income")
    public ModelAndView getIncomes() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/income");
        modelAndView.addObject("incomeList", incomeRepository.findAll());

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }

    /**
     * Add income mapping
     *
     * @return
     */

    @GetMapping("/ssi/income/add")
    public ModelAndView addNewIncome() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add_income");
        modelAndView.addObject("income", new IncomeModel());
        return modelAndView;
    }

    /**
     * Edit income mapping
     *
     * @param incomeId
     * @return
     */

    @GetMapping("/ssi/income/edit/{incomeId}")
    public ModelAndView editIncome(@PathVariable Integer incomeId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/edit_income");
        IncomeEntity incomeEntity = incomeRepository.findById(incomeId).get();
        IncomeModel incomeModel = new IncomeModel();

        // Field
        incomeModel.setDate(incomeEntity.getDate());
        incomeModel.setCurrency(incomeEntity.getCurrency());
        incomeModel.setValue(incomeEntity.getValue());

        return modelAndView;
    }

    @GetMapping("/ssi/income/delete/{incomeId}")
    public ModelAndView deleteIncome(@PathVariable Integer incomeId) {

        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/income");
        incomeRepository.deleteById(incomeId);
        return modelAndView;
    }

    @PostMapping("/ssi/income/save")
    public ModelAndView saveIncome(@ModelAttribute("income") IncomeModel incomeModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/income");
        IncomeEntity incomeEntity;
        if (incomeModel.getIncomeId() != null) {
            incomeEntity = incomeRepository.findById(incomeModel.getIncomeId()).get();
        } else {
            incomeEntity = new IncomeEntity();
        }

        // Fields
        incomeEntity.setDate(incomeModel.getDate());
        incomeEntity.setCurrency(incomeModel.getCurrency());
        incomeEntity.setValue(incomeModel.getValue());

        // Save
        incomeRepository.save(incomeEntity);

        return modelAndView;
    }


}
