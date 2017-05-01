package br.com.gti.profectus.web.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.gti.profectus.infra.scheduled.task.TaskExecutor;

/**
 * SchedulingConfig.
 * @since 17/12/2015
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "br.com.gti" }, includeFilters = @Filter(Controller.class), useDefaultFilters = false)
@Import({ CacheConfig.class, JpaConfig.class })
@EnableSpringDataWebSupport
public class SchedulingConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * transactionManager.
     * @since 17/12/2015
     * @param entityMFactory
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory entityMFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityMFactory);

        return tm;
    }

    /**
     * taskScheduler.
     * @return
     */
    @Bean(name = "taskExecutor")
    public TaskExecutor taskScheduler() {
        return new TaskExecutor();
    }
}
