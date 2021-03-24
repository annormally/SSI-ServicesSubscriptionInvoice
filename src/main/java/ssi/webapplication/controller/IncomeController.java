package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    /**
     * Printing at console a message to see if the class work.
     */

    public IncomeController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Injecting collaborating beans.
     */

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Mapping for "Income" page.
     *
     * @return modelAndView;
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
     * "Add-Income" method for income.
     *
     * @return modelAndView;
     */

    @GetMapping("/ssi/income/add")
    public ModelAndView addNewIncome() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add-edit-incomes");
        modelAndView.addObject("income", new IncomeModel());
        return modelAndView;
    }

    /**
     * "Edit-Income" method for income.
     *
     * @param incomeId
     * @return modelAndView;
     */

    @GetMapping("/ssi/income/edit/{incomeId}")
    public ModelAndView editIncome(@PathVariable Integer incomeId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add-edit-incomes");
        IncomeEntity incomeEntity = incomeRepository.findById(incomeId).get();
        IncomeModel incomeModel = new IncomeModel();

        // Field
        incomeModel.setIncomeId(incomeEntity.getIncomeId());
        incomeModel.setDate(incomeEntity.getDate());
        incomeModel.setCurrency(incomeEntity.getCurrency());
        incomeModel.setValue(incomeEntity.getValue());

        modelAndView.addObject("income", incomeModel);

        return modelAndView;
    }

    /**
     * "Delete" method for income.
     *
     * @param incomeId
     * @return modelAndView;
     */

    @GetMapping("/ssi/income/delete/{incomeId}")
    public ModelAndView deleteIncome(@PathVariable Integer incomeId) {

        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/income");
        incomeRepository.deleteById(incomeId);
        return modelAndView;
    }

    /**
     * "Save" method for income.
     *
     * @param incomeModel
     * @param bindingResult
     * @return modelAndView;
     */

    @PostMapping("/ssi/income/save")
    public ModelAndView saveIncome(@ModelAttribute("income") IncomeModel incomeModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/income");

        // Requiring a specific field(sending a message for user that what he introduce is not what is required).
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("income", incomeModel);
            modelAndView.setViewName("secondary_pages/add-edit-incomes");
            return modelAndView;
        }

        // Verifying that incomeId doesn't exists and creating a new income.
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

        // Get authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null != auth && auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            incomeEntity.setUsername(user.getUsername());
        }

        // Save income
        incomeRepository.save(incomeEntity);
        return modelAndView;
    }

}
