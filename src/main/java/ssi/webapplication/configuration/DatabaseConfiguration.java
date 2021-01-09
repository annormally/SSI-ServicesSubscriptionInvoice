package ssi.webapplication.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("ssi.webapplication.entities")
@EnableJpaRepositories("ssi.webapplication.repositories")
public class DatabaseConfiguration {
}
