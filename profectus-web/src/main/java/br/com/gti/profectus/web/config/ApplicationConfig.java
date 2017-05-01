package br.com.gti.profectus.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ApplicationConfig.
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = { "br.com.gti" }, excludeFilters = @Filter({Controller.class, Configuration.class }))
@Import({CacheConfig.class, JpaConfig.class, SchedulingConfig.class, SecurityConfig.class })
public class ApplicationConfig {


    @Bean
    public MultipartResolver filterMultipartResolver() {
        return new CommonsMultipartResolver();
    }
}
