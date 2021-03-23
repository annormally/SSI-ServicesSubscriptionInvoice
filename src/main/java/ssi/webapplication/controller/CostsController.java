package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.model.CostsModel;
import ssi.webapplication.entities.CostsEntity;
import ssi.webapplication.repositories.CostsRepository;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class CostsController {

    public CostsController() {
        System.out.println(getClass().getName() + " created.");
    }

    @Autowired
    private CostsRepository costsRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Costs page mapping
     *
     * @return
     */

    @GetMapping("/ssi/costs")
    public ModelAndView getCosts() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/costs");
        modelAndView.addObject("costsList", costsRepository.findAll());

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }

    /**
     * Add costs mapping
     */

    @GetMapping("/ssi/costs/add")
    public ModelAndView addNewCost() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add_costs");
        modelAndView.addObject("cost", new CostsModel());
        return modelAndView;
    }

    /**
     * Edit costs mapping
     */

    @GetMapping("/ssi/costs/edit/{costsId}")
    public ModelAndView editCost(@PathVariable Integer costsId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/edit_costs");
        CostsEntity costsEntity = costsRepository.findById(costsId).get();
        CostsModel costsModel = new CostsModel();

        // Fields
        costsModel.setDate(costsEntity.getDate());
        costsModel.setCurrency(costsEntity.getCurrency());
        costsModel.setValue(costsEntity.getValue());

        modelAndView.addObject("cost", costsModel);

        return modelAndView;
    }

    /**
     * Delete costs mapping
     */

    @GetMapping("ssi/costs/delete/{costsId}")
    public ModelAndView deleteCost(@PathVariable Integer costsId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/costs");
        costsRepository.deleteById(costsId);
        return modelAndView;
    }

    /**
     * Save cost mapping
     */

    @PostMapping("/ssi/costs/save")
    public ModelAndView saveCosts(@ModelAttribute("cost") CostsModel costsModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/costs");
        CostsEntity costsEntity;
        if (costsModel.getCostId() != null) {
            costsEntity = costsRepository.findById(costsModel.getCostId()).get();
        } else {
            costsEntity = new CostsEntity();
        }

        // Fields
        costsEntity.setDate(costsModel.getDate());
        costsEntity.setCurrency(costsModel.getCurrency());
        costsEntity.setValue(costsModel.getValue());

        // Save
        costsRepository.save(costsEntity);

        return modelAndView;
    }
}
