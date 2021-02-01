package ssi.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ssi.webapplication.Model.UserInfoModel;
import ssi.webapplication.Model.UserModel;
import ssi.webapplication.entities.UserEntity;
import ssi.webapplication.entities.UserInfoEntity;
import ssi.webapplication.repositories.UserInfoRepository;
import ssi.webapplication.repositories.UserRepository;

@Controller
public class UserInfoController {

    public UserInfoController() {
        System.out.println(getClass().getName() + " created.");
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * User Information for editing mapping
     *
     * @return
     */

    @GetMapping("/ssi/user/info/edit")
    public ModelAndView getUserInfoEdit() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user_info");
        modelAndView.addObject("userList", userRepository.findAll());
        return modelAndView;
    }

    /**
     * User Information mapping
     *
     * @return
     */

    @GetMapping("/ssi/user/information")
    public ModelAndView getUserInformation() {
        ModelAndView modelAndView = new ModelAndView("secondary_pages/user_information");
        modelAndView.addObject("userList", userRepository.findAll());
        return modelAndView;
    }

    /**
     * User information editing
     *
     * @return
     */

    @GetMapping("/ssi/user/info/edit/{id}")
    public ModelAndView getEditUserInfo(@PathVariable("id") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");
        UserEntity userEntity = userRepository.findById(userId).get();
        UserInfoModel userInfoModel = new UserInfoModel();

        // Set main fields
        userInfoModel.setUserId(userEntity.getUserId());
        userInfoModel.setEmail(userEntity.getEmail());
        userInfoModel.setUsername(userInfoModel.getUsername());
        userInfoModel.setPassword(userInfoModel.getPassword());
        if (userEntity.getUserInfoEntity() != null) {

            // Set information fields
            userInfoModel.setName(userEntity.getUserInfoEntity().getName());
            userInfoModel.setLastName(userEntity.getUserInfoEntity().getLastName());
            userInfoModel.setPhoneNumber(userEntity.getUserInfoEntity().getPhoneNumber());
            userInfoModel.setCountry(userEntity.getUserInfoEntity().getCountry());
        }
        modelAndView.addObject("user", userInfoModel);
        return modelAndView;
    }

    @PostMapping("/ssi/user/info/save")
    public ModelAndView getSaveUserInfo(@ModelAttribute("user_info") UserInfoModel userInfoModel) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        UserEntity userEntity;
        if (userInfoModel.getUserId() != null) {
            userEntity = userRepository.findById(userInfoModel.getUserId()).get();
        } else {
            userEntity = new UserEntity();
        }

        // Set main fields
        userEntity.setEmail(userInfoModel.getEmail());
        userEntity.setUsername(userInfoModel.getUsername());
        userEntity.setPassword(userInfoModel.getPassword());

        UserInfoEntity userInfoEntity;
        if (userInfoModel.getUserId() != null) {
            userInfoEntity = userInfoRepository.findById(userInfoModel.getUserId()).get();
        } else {
            userInfoEntity = new UserInfoEntity();
        }

        // Set information fields
        userInfoEntity.setName(userInfoModel.getName());
        userInfoEntity.setLastName(userInfoModel.getLastName());
        userInfoEntity.setPhoneNumber(userInfoModel.getPhoneNumber());
        userInfoEntity.setCountry(userInfoModel.getCountry());
        return modelAndView;
    }
}
