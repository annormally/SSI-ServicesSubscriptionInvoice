package ssi.webapplication.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Setting the default language for the application.
     *
     * @return resolver;
     */

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        return resolver;
    }

    /**
     * Setting the extension form the application who change the language.
     * For example:
     * <p>
     * url => "/login" -> to change at "english" = "/login?language=en"
     * url => "/login" -> to change at "romanian" = "/login?language=ro"
     *
     * @return interceptor;
     */

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    /**
     * Location from the application.
     * From here take the message(text from the page).
     *
     * @return (messageSource)message;
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource message = new ReloadableResourceBundleMessageSource();
        message.setBasename("classpath:/languages/language");
        return message;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * Source for design and images.
     *
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/logo/**").addResourceLocations("classpath:/static/logo/");
        registry.addResourceHandler("/icon/**").addResourceLocations("classpath:/static/icon/");
    }

}
