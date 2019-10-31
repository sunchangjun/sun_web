package com.sun.web.config;


import com.utils.PropertiesConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.sun.web.dao"}, sqlSessionTemplateRef = "iptvSqlSessionTemplate")
public class IptvDataSourceConfig {

    private String mapperLocations="classpath*:mapper/*.xml";

    @Primary
    @Bean(name = "iptvDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.iptv")
    public DataSource dataSource() {
        HikariDataSource hikariPool=new HikariDataSource();
        hikariPool.setJdbcUrl(PropertiesConfig.getValue("spring.datasource.druid.iptv.url"));
        hikariPool.setUsername(PropertiesConfig.getValue("spring.datasource.druid.iptv.username"));
        hikariPool.setPassword(PropertiesConfig.getValue("spring.datasource.druid.iptv.password"));
        hikariPool.setDriverClassName(PropertiesConfig.getValue("spring.datasource.druid.iptv.driverClassName"));
//        hikariPool.setUsername(PropertiesConfig.getValue(""));
//        hikariPool.setUsername(PropertiesConfig.getValue(""));
//        hikariPool.setUsername(PropertiesConfig.getValue(""));

//        return DataSourceBuilder.create().build();
        return hikariPool;
    }

    @Primary
    @Bean(name = "iptvSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("iptvDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "iptvTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("iptvDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "iptvSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("iptvSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "iptvJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("iptvDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

