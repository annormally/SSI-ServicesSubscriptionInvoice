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

    public UsersController() {
        System.out.println(getClass().getName() + " created.");
    }

    @Autowired
    private UserRepository userRepository;

    /**
     * Page "user_info" is for editing user.
     * Page "user_information" is for display user information into a table.
     */

    /**
     * Mapping for display "user_info" page.
     */

    @GetMapping("ssi/user/info")
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user_info");
        modelAndView.addObject("userInfo", new UserEntity());

        // To find user used a list
        modelAndView.addObject("userList", userRepository.findAll());

        return modelAndView;
    }

    /**
     * Mapping for editing an user.
     *
     * @param userId
     * @return
     */

    @GetMapping("/ssi/user/info/edit/{userId}")
    public ModelAndView getEditUserInfo(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user_info");
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
     * Mapping for display "user_information" page.
     */


    @GetMapping("ssi/user/information")
    public ModelAndView getUserInformationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInformationList", userRepository.findAll());
        return modelAndView;
    }

    @GetMapping("ssi/user/information/{userId}")
    public ModelAndView getUserInformation(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user_information");
        modelAndView.addObject("userInformation", userRepository.findById(userId).get());
        return modelAndView;
    }

}
