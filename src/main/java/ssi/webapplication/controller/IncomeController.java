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

// TODO: 25/01/2021 implement all method add, edit, delete and save

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
        // TODO: 3/1/2021 add page "add_income"
        ModelAndView modelAndView = new ModelAndView("");
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
        // TODO: 3/1/2021 add page "edit_income"
        ModelAndView modelAndView = new ModelAndView("");
        IncomeEntity incomeEntity = incomeRepository.findById(incomeId).get();
        IncomeModel incomeModel = new IncomeModel();

        // Field
        incomeModel.setDate(incomeEntity.getDate());
        incomeModel.setSupportDocument(incomeEntity.getSupportDocument());
        incomeModel.setCurrency(incomeEntity.getCurrency());
        incomeModel.setValue(incomeEntity.getValue());
        incomeModel.setTva(incomeEntity.getTva());
        incomeModel.setTvaValue(incomeEntity.getTvaValeu());
        incomeModel.setTotalValuePlusTva(incomeEntity.getTotalValeuPlusTva());

        return modelAndView;
    }

    @GetMapping("/ssi/income/delete/{incomeId}")
    public ModelAndView deleteIncome(@PathVariable Integer incomeId) {
        // TODO: 3/1/2021 introduce the redirect page
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        incomeRepository.deleteById(incomeId);
        return modelAndView;
    }

    @PostMapping("/ssi/income/save")
    public ModelAndView saveIncome(@ModelAttribute("income") IncomeModel incomeModel) {
        // TODO: 3/1/2021 introduce the redirect page
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        IncomeEntity incomeEntity;
        if (incomeModel.getIncomeId() != null) {
            incomeEntity = incomeRepository.findById(incomeModel.getIncomeId()).get();
        } else {
            incomeEntity = new IncomeEntity();
        }

        // Fields
        incomeEntity.setDate(incomeModel.getDate());
        incomeEntity.setSupportDocument(incomeEntity.getSupportDocument());
        incomeEntity.setCurrency(incomeModel.getCurrency());
        incomeEntity.setValue(incomeModel.getValue());
        incomeEntity.setTva(incomeModel.getTva());
        incomeEntity.setTvaValeu(incomeModel.getTvaValue());
        incomeEntity.setTotalValeuPlusTva(incomeModel.getTotalValuePlusTva());

        // Save
        incomeRepository.save(incomeEntity);

        return modelAndView;
    }


}
