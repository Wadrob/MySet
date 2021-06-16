package com.github.wadrob.myset.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

public class WebConfig {


    @Bean(name = "localeResolver")
    public LocaleContextResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.forLanguageTag("pl"));
        return sessionLocaleResolver;
    }
}
