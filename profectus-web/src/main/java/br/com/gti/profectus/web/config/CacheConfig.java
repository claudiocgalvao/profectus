package br.com.gti.profectus.web.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

/**
 * CacheConfig.
 */
@Configuration
@EnableCaching
/**SPRING 4.3.3**/
public class CacheConfig extends CachingConfigurerSupport {

	/**
	 * Ref.: http://www.concretepage.com/spring-4/spring-4-guava-cache-integration-example-with-guavacachemanager-and-guavacache
	*/
	@Bean
    public CacheManager cacheManager() {
       GuavaCacheManager cacheManager = new GuavaCacheManager("gtiCache");
       CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
       .maximumSize(100)
       .expireAfterWrite(10, TimeUnit.MINUTES);
       cacheManager.setCacheBuilder(cacheBuilder);
       return cacheManager;
    }
    
}


//public class CacheConfig implements CachingConfigurer {
///**
//* cacheManager.
//*/
//public CacheManager cacheManager() {
//  GuavaCacheManager cacheManager = new GuavaCacheManager();
//  return cacheManager;
//}
//
///**
//* keyGenerator.
//*/
//public KeyGenerator keyGenerator() {
//  return new SimpleKeyGenerator();
//}
//}