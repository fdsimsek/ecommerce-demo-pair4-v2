package com.etiya.ecommercedemopair4.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        // Veritabanı?
        // Dosya
        // API
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        //Clientdan seçili dili hangi yöntemle almalıyım
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

        // Dil gönderilmemişse hangi dil baz alayım?
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));

        return acceptHeaderLocaleResolver;
    }
}
