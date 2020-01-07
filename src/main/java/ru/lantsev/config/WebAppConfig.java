package ru.lantsev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.lantsev")
public class WebAppConfig implements WebMvcConfigurer {

    /*
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    @Bean
    UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        //viewResolver.setPrefix("/WEB-INF/views/");
        //viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    @Bean
    TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer() ;
        tilesConfigurer.setDefinitions("/WEB-INF/layouts/tiles.xml");
        return tilesConfigurer ;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor() ;
    }

    @Bean
    CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver() ;
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver ;
    }

    @Bean
    ThemeChangeInterceptor themeChangeInterceptor() {
        return new ThemeChangeInterceptor() ;
    }

    @Bean
    ResourceBundleThemeSource themeSource() {
        return new ResourceBundleThemeSource() ;
    }

    @Bean
    CookieThemeResolver themeResolver() {
        CookieThemeResolver cookieThemeResolver = new CookieThemeResolver() ;
        cookieThemeResolver.setDefaultThemeName("standard");
        cookieThemeResolver.setCookieMaxAge(3600);
        cookieThemeResolver.setCookieName("theme");
        return cookieThemeResolver ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/")
                .setCachePeriod(31556926) ;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor()) ;
        registry.addInterceptor(themeChangeInterceptor()) ;
    }
}
