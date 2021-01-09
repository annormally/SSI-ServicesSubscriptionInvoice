package ssi.webapplication.controller.main_pages_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssi.webapplication.controller.LoginController;

import static org.assertj.core.api.Assertions.assertThat;


class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    void getLoginPage() {
        assertThat(loginController).as("maine_pages/login");
        assertThat(loginController).isNull();
    }

    @Test
    void getLoginPageWithLogin() {
        assertThat(loginController).as("maine_pages/login");
    }

    @Test
    void currentUsername() {
        assertThat(loginController).isNull();
    }
}