package br.com.gti.profectus.web.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebMvcSecurity
// public class SecurityConfig {
//
// //@Bean
// //public UserDetailsService userDetailsService() {
// //return new CustomUserDetailsService();
// //}
// private static void configure(final HttpSecurity http) throws Exception {
// http.authorizeRequests().antMatchers("/resources/**", "/assets/**").permitAll().anyRequest().authenticated()
// .and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
// }
//
// // @Configuration
// // @EnableWebSecurity(debug = true)
// // @Profile(ConfigurationConstants.DEV_PROFILE)
// // public static class DevelopmentConfig extends WebSecurityConfigurerAdapter {
// //
// // @Autowired
// // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
// // }
// //
// // @Override
// // protected void configure(final HttpSecurity http) throws Exception {
// // SecurityConfig.configure(http);
// // }
// // }
//
// // @Configuration
// // @EnableWebSecurity
// // @Profile(ConfigurationConstants.SECURITY_GATEWAY_PROFILE)
// // public static class ProductionConfig extends WebSecurityConfigurerAdapter {
// //
// // @Autowired
// // public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
// // auth.userDetailsService(userDetailsService());
// // }
// //
// // @Override
// // protected void configure(final HttpSecurity http) throws Exception {
// // SecurityConfig.configure(http);
// // http.addFilterBefore(siteMinderFilter(), UsernamePasswordAuthenticationFilter.class);
// // }
// //
// // @Bean
// // public RequestHeaderAuthenticationFilter siteMinderFilter() throws Exception {
// // RequestHeaderAuthenticationFilter siteMinderFilter = new RequestHeaderAuthenticationFilter();
// // siteMinderFilter.setPrincipalRequestHeader("SM_USER");
// // siteMinderFilter.setAuthenticationManager(authenticationManager());
// // return siteMinderFilter;
// // }
// // }
// }

/**
 * SecurityConfig.
 * SecurityConfig.
 * @author eduardo.fsantos
 * @since 03/12/2014
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  /**
   * configAuthentication.
   * @author eduardo.fsantos
   * @since 03/12/2014
   * @param auth
   * @throws Exception void
   */
  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication().dataSource(this.dataSource)
        .usersByUsernameQuery("select username, password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
  }

  /**
   * configureGlobal.
   * @author eduardo.fsantos
   * @since 03/12/2014
   * @param auth
   * @throws Exception void
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    ///auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");

    //auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema().withUser("user").password("password")
    //        .roles("USER").and().withUser("admin").password("password").roles("USER", "ADMIN");

    auth.jdbcAuthentication().dataSource(this.dataSource)
        .usersByUsernameQuery("select username, password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/resources/**", "/assets/**").permitAll().anyRequest().authenticated().and()
        .formLogin().loginPage("/login").permitAll().and().exceptionHandling().accessDeniedPage("/403").and().logout()
        .logoutUrl("/logout").logoutSuccessUrl("/").and().rememberMe().and().csrf().disable();
    //

    //        http.authorizeRequests().antMatchers("/resources/**", "/assets/**").permitAll().and().formLogin()
    //                .loginPage("/login").permitAll();

    //        http.authorizeRequests().antMatchers("/resources/**", "/assets/**").permitAll().and().formLogin()
    //                .loginPage("/login").failureUrl("/login?error").usernameParameter("username")
    //                .passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout").and()
    //                .exceptionHandling().accessDeniedPage("/403").and().csrf().disable();

    //http.authorizeRequests().antMatchers("/resources/**", "/assets/**").permitAll().anyRequest().authenticated()
    //        .and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();

  }

}
