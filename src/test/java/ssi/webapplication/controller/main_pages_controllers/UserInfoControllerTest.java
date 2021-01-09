package ssi.webapplication.controller.main_pages_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssi.webapplication.controller.UserInfoController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserInfoControllerTest {

    @Autowired
    private UserInfoController userInfoController;

    @Test
    void getUserInfo() {
        assertThat(userInfoController).as("secondary_pages/user_info");
    }

    @Test
    void getEditUserInfo() {
        assertThat(userInfoController).as("/");
    }
}