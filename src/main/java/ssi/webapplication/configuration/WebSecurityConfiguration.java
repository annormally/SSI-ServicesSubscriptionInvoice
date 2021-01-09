package ssi.webapplication.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        /**
         *  Configuration for all user
         */

        http.authorizeRequests()
                .antMatchers("/", "/signup", "/login", "/login/errors", "/403", "/css/**", "/img/**")
                .permitAll();

        /**
         * Configuration for logged user
         */

        http.authorizeRequests()
                .antMatchers("/ssi/homepage", "/ssi/costs", "/ssi/incomes", "/ssi/user/info")
                // work for all users
//                .permitAll();
        // work just for logged user
                .hasRole("USER");

        /**
         *  Configuration for any request
         *  Other request need to be authenticate
         */

        http.authorizeRequests()
                .anyRequest().authenticated();

        /**
         * Configuration page for access denied
         */

        http.exceptionHandling()
                .accessDeniedPage("/403");

        /**
         * Configuration for login
         */

        http.formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .defaultSuccessUrl("/ssi/homepage")
                .failureUrl("/403");

        /**
         * Configuration for logout
         */

        http.logout()
                .logoutUrl("/logout")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    }

}
