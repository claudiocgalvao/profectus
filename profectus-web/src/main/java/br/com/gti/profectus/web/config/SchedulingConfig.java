package br.com.gti.profectus.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import br.com.gti.profectus.infra.scheduled.task.TaskExecutor;

/**
 * SchedulingConfig.
 * 
 * @since 17/12/2015
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "br.com.gti" }, includeFilters = @Filter(Controller.class), useDefaultFilters = false)
@Import({ CacheConfig.class, MongoConfig.class })
@EnableSpringDataWebSupport
public class SchedulingConfig {

	/**
	 * transactionManager.
	 * 
	 * @since 17/12/2015
	 * @param entityMFactory
	 * @return
	 */
//	@Bean
//	public PlatformTransactionManager transactionManager(final EntityManagerFactory entityMFactory) {
//		JpaTransactionManager tm = new JpaTransactionManager();
//		tm.setEntityManagerFactory(entityMFactory);
//		return tm;
//	}

	/**
	 * taskScheduler.
	 * 
	 * @return
	 */
	@Bean(name = "taskExecutor")
	public TaskExecutor taskScheduler() {
		return new TaskExecutor();
	}
}
