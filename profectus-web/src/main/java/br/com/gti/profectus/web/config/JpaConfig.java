//package br.com.gti.profectus.web.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.jta.WebSphereUowTransactionManager;
//
///**
// * JpaConfig.
// */
////@Configuration
////@EnableJpaRepositories(basePackages = { "br.com.gti" })
//public class JpaConfig {
//
//	
//    /**
//     * EntityManagerFactory.
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
//                                                                       final JpaVendorAdapter jpaVendorAdapter) {
//        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        factoryBean.setPackagesToScan(new String[] {"br.com.gti"});
//        return factoryBean;
//    }
//
////  @Profile("production")
//    @Configuration
//    public static class ProdutionConfig {
//
//        private static final String JNDI_DATASOURCE_NAME = "jdbc/u885303517_gtidb";
//
//        /**
//         * DataSource.
//         */
//        @Bean
//        public DataSource dataSource() {
//            final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//            DataSource dataSource = dsLookup.getDataSource(JNDI_DATASOURCE_NAME);
//            return dataSource;
//        }
//
//        /**
//         * TransactionManager.
//         */
//        @Bean
//        public PlatformTransactionManager transactionManager() {
//            return new WebSphereUowTransactionManager();
//        }
//
//        /**
//         * JpaVendorAdapter.
//         */
//        @Bean
//        public JpaVendorAdapter jpaVendorAdapter() {
//            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//            vendorAdapter.setDatabase(Database.MYSQL);
//            vendorAdapter.setShowSql(true);
//            vendorAdapter.setGenerateDdl(false);
//            return vendorAdapter;
//        }
//    }
//}
