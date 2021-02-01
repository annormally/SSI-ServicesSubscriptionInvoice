package ssi.webapplication.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication()
@ComponentScan("ssi.webapplication")
@Import({DatabaseConfiguration.class, WebConfiguration.class, WebSecurityConfiguration.class})
public class AppConfiguration {

    private static Logger logger = LoggerFactory.getLogger(AppConfiguration.class);

    public static void main(String[] args) {
        logger.info("Container started .... ");
        SpringApplication.run(AppConfiguration.class, args);
    }
}
