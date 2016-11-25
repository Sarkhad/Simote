package org.simote;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class SimoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimoteApplication.class, args);
	}
	
	@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
	
	@Bean

    public LocaleResolver localeResolver() {

        SessionLocaleResolver slr = new SessionLocaleResolver();

        slr.setDefaultLocale(Locale.US);
        
        return slr;

    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:i18n/messages");

        messageSource.setCacheSeconds(3600); //refresh cache once per hour

        return messageSource;

    }
    
    @Bean
    public ThemeSource themeSource() {
    	ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
    	themeSource.setBasenamePrefix("themes/");
    	return themeSource;
    }
    
    @Bean
    public ThemeResolver themeResolver() {
    	ThemeResolver themeResolver = new org.simote.thymeleaf.ThemeResolver();
    	return themeResolver;
    }
    

}
