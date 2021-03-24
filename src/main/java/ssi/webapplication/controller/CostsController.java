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
import ssi.webapplication.model.CostsModel;
import ssi.webapplication.entities.CostsEntity;
import ssi.webapplication.repositories.CostsRepository;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class CostsController {

    /**
     * Printing at console a message to see if the class work.
     */

    public CostsController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Injecting collaborating beans.
     */

    @Autowired
    private CostsRepository costsRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Get mapping for "Costs" page.
     *
     * @return modelAndView;
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
     * "Add-Costs" method for "Costs" page.
     *
     * @return modelAndView;
     */

    @GetMapping("/ssi/costs/add")
    public ModelAndView addNewCost() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add-edit-costs");
        modelAndView.addObject("cost", new CostsModel());
        return modelAndView;
    }

    /**
     * "Edit-Costs" method for "Costs" page.
     *
     * @param costsId
     * @return modelAndView;
     */

    @GetMapping("/ssi/costs/edit/{costsId}")
    public ModelAndView editCost(@PathVariable Integer costsId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/add-edit-costs");

        CostsEntity costsEntity = costsRepository.findById(costsId).get();

        // Fields
        CostsModel costsModel = new CostsModel();
        costsModel.setCostId(costsEntity.getCostId());
        costsModel.setDate(costsEntity.getDate());
        costsModel.setValue(costsEntity.getValue());
        costsModel.setCurrency(costsEntity.getCurrency());

        modelAndView.addObject("cost", costsModel);

        return modelAndView;
    }

    /**
     * "Delete" method for costs.
     *
     * @param costsId
     * @return modelAndView;
     */

    @GetMapping("ssi/costs/delete/{costsId}")
    public ModelAndView deleteCost(@PathVariable Integer costsId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/costs");
        costsRepository.deleteById(costsId);
        return modelAndView;
    }

    /**
     * "Save" method for Add and Edit costs.
     *
     * @param costsModel
     * @param bindingResult
     * @return modelAndView;
     */

    @PostMapping("/ssi/costs/save")
    public ModelAndView saveCosts(@ModelAttribute("cost") CostsModel costsModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/costs");

        // Requiring a specific field(sending a message for user that what he introduce is not what is required).
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("costs", costsModel);
            modelAndView.setViewName("secondary_pages/add-edit-costs");
            return modelAndView;
        }

        // Verifying that costsId doesn't exists and creating a new cost.
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

        // Get authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null != auth && auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            costsEntity.setUsername(user.getUsername());
        }

        // Save cost
        costsRepository.save(costsEntity);

        return modelAndView;
    }
}
