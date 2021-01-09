package ssi.webapplication.controller.main_pages_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssi.webapplication.controller.SSIController;

import javax.persistence.criteria.CriteriaBuilder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SSIControllerTest {

    @Autowired
    private SSIController ssiController;

    @Test
    void getSSIGeneralPage() {
        assertThat(ssiController).as("main_pages/ssiHomepage");

    }
}
