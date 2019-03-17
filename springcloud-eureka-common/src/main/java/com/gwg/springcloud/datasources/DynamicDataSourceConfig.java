package com.gwg.springcloud.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 引入druid-spring-boot-starter之后配置数据源就很简单了
 * 配置多数据源
 *
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    //单数据源配置方式
    @Bean
    @Primary
    @DependsOn({"firstDataSource"})
    public DynamicDataSource dataSource(DataSource firstDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);

    }


    //多数据源配置方式
    @Bean
    @Primary
    @DependsOn({"firstDataSource","secondDataSource"})
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }


}
