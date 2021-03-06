package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.model.UserModel;
import ssi.webapplication.entities.AuthoritiesEntity;
import ssi.webapplication.entities.UserEntity;
import ssi.webapplication.repositories.UserAuthoritiesRepository;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class SignUpController {

    /**
     * Printing at console a message to see if the class work.
     */

    public SignUpController() {
        System.out.println(getClass().getName() + " created.");
    }


    /**
     * Injecting collaborating beans.
     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthoritiesRepository userAuthoritiesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Mapping for "Signup" page.
     *
     * @return modelAndView;
     */

    @GetMapping("/signup")
    public ModelAndView getSingUp() {
        ModelAndView modelAndView = new ModelAndView("main_pages/signup");
        modelAndView.addObject("user", new UserModel());
        return modelAndView;
    }

    /**
     * "Save" method for signup a user.
     *
     * @param userModel
     * @return modelAndView;
     */

    @PostMapping("/signup")
    public ModelAndView saveUser(@ModelAttribute("user") UserModel userModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        // Verifying that userId doesn't exists and creating a new user.
        UserEntity userEntity;
        if (userModel.getUserId() != null) {
            userEntity = userRepository.findById(userModel.getUserId()).get();
        } else {
            userEntity = new UserEntity();
        }

        // Set main fields
        userEntity.setLocked(true);
        userEntity.setEmail(userModel.getEmail());
        userEntity.setUsername(userModel.getUsername().trim());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));

        // Set authority value
        AuthoritiesEntity authoritiesEntity;
        if (userModel.getUserId() != null) {
            authoritiesEntity = userAuthoritiesRepository.findById(userModel.getUserId()).get();
        } else {
            authoritiesEntity = new AuthoritiesEntity();
        }

        // Set authority fields
        authoritiesEntity.setUsername(userModel.getUsername());
        authoritiesEntity.setAuthority("USER");
        authoritiesEntity.setUser(userEntity);

        // Save user
        userRepository.save(userEntity);

        // Save authority
        userAuthoritiesRepository.save(authoritiesEntity);

        return modelAndView;
    }

}
