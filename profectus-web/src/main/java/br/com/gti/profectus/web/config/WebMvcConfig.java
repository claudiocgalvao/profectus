package br.com.gti.profectus.web.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * WebMvcConfig.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "br.com.gti" }, includeFilters = @Filter(Controller.class), useDefaultFilters = false)
@EnableSpringDataWebSupport
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  private static final Integer CACHE_SECONDS = 5;

  private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  /**
   * MultipartResolver.
   */
  @Bean
  public CommonsMultipartResolver multipartResolver() {
    return new CommonsMultipartResolver();
  }

  /**
   * MessageSource.
   */
  @Bean(name = "messageSource")
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename(MESSAGE_SOURCE);
    messageSource.setCacheSeconds(CACHE_SECONDS);
    return messageSource;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/thirdparty/");
    registry.addResourceHandler("/assets/**").addResourceLocations("/resources/citi/");
  }

//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("home/home");
//    registry.addViewController("/index").setViewName("home/home");
//    registry.addViewController("/index.html").setViewName("home/home");
//  }
  
  @Bean
  public ViewResolver viewResolver() {
      InternalResourceViewResolver bean = new InternalResourceViewResolver();

      bean.setViewClass(JstlView.class);
      bean.setPrefix("/views/");
      bean.setSuffix(".html");
      return bean;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    OpenEntityManagerInViewInterceptor entityManagerInterceptor = new OpenEntityManagerInViewInterceptor();
    entityManagerInterceptor.setEntityManagerFactory(this.entityManagerFactory);
    registry.addWebRequestInterceptor(entityManagerInterceptor);
  }

//  @Override
//  public Validator getValidator() {
//    LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//    validator.setValidationMessageSource(this.messageSource());
//    return validator;
//  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
}
