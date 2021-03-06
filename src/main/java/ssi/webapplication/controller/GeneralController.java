package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.entities.ContactEntity;
import ssi.webapplication.model.ContactModel;
import ssi.webapplication.repositories.ContactRepository;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class GeneralController {

    /**
     * Printing at console a message to see if the class work.
     */

    public GeneralController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Injecting collaborating beans.
     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    /**
     * Mapping for "home" page.
     *
     * @return modelAndView;
     */

    @GetMapping("/ssi/home")
    public ModelAndView getHomepage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/home");

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }

    /**
     * Mapping for "Contact" page.
     *
     * @return modelAndView;
     */

    @GetMapping("/ssi/contact")
    public ModelAndView getContactPage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/contact");
        modelAndView.addObject("message", new ContactModel());
        return modelAndView;
    }

    /**
     * "Save message" method from user.
     *
     * @param contactModel
     * @return
     */

    @PostMapping("/ssi/contact")
    public ModelAndView saveContactMessage(@ModelAttribute("message") ContactModel contactModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/ssi/home");
        ContactEntity contactEntity;
        if (contactModel.getContactId() != null) {
            contactEntity = contactRepository.findById(contactModel.getContactId()).get();
        } else {
            contactEntity = new ContactEntity();
        }

        // Set fields
        contactEntity.setName(contactModel.getName());
        contactEntity.setEmail(contactModel.getEmail());
        contactEntity.setMessage(contactModel.getMessage());

        // Save contact message
        contactRepository.save(contactEntity);

        return modelAndView;
    }

    /**
     * Mapping for "About" page.
     *
     * @return modelAndView;
     */

    @GetMapping("/ssi/about")
    public ModelAndView getAboutPage() {
        ModelAndView modelAndView = new ModelAndView("main_pages/about");
        return modelAndView;
    }
}