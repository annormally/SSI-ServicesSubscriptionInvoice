package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.entities.UserEntity;
import ssi.webapplication.model.UserModel;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class UsersController {

    /**
     * Printing at console a message to see if the class work.
     */

    public UsersController() {
        System.out.println(getClass().getName() + " created.");
    }

    /**
     * Injecting collaborating beans.
     */

    @Autowired
    private UserRepository userRepository;

    /**
     * Mapping for "user-info".
     *
     * @return modelAndView;
     */

    @GetMapping("ssi/user/info")
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user-info");
        modelAndView.addObject("userInfo", new UserEntity());

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }

    /**
     * Mapping for editing an user.
     *
     * @param userId
     * @return modelAndView;
     */

    @GetMapping("/ssi/user/info/edit/{userId}")
    public ModelAndView getEditUserInfo(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user-info");
        UserEntity userEntity = userRepository.findById(userId).get();
        UserModel userModel = new UserModel();

        // Set editing fields
        userModel.setUserId(userEntity.getUserId());
        userModel.setName(userEntity.getName());
        userModel.setLastName(userEntity.getLastName());
        userModel.setPhoneNumber(userEntity.getPhoneNumber());
        userModel.setCountry(userEntity.getCountry());

        return modelAndView;
    }


    /**
     * "Save" method for editing a user.
     *
     * @param userModel
     * @return
     */

    @PostMapping("ssi/user/info/save")
    public ModelAndView getSaveUserInfo(@ModelAttribute("userInfo") UserModel userModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        UserEntity userEntity;

        if (userModel.getUserId() != null) {
            userEntity = userRepository.findById(userModel.getUserId()).get();
        } else {
            userEntity = new UserEntity();
        }

        // Fields to save
        userEntity.setUserId(userModel.getUserId());
        userEntity.setUsername(userModel.getUsername());
        userEntity.setName(userModel.getName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setPhoneNumber(userModel.getPhoneNumber());
        userEntity.setCountry(userModel.getCountry());

        // Save
        userRepository.save(userEntity);
        return modelAndView;
    }


    /**
     * Mapping for display "user-information" page.
     *
     * @return modelAndView;
     */

    @GetMapping("ssi/user/information")
    public ModelAndView getUserInformationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInformationList", userRepository.findAll());
        return modelAndView;
    }

    @GetMapping("ssi/user/information/{userId}")
    public ModelAndView getUserInformation(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user-information");
        modelAndView.addObject("userInformation", userRepository.findById(userId).get());
        return modelAndView;
    }

}
