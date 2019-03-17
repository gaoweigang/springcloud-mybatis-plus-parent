package com.gwg.springcloud.config;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
		return paginationInterceptor;
	}

//	/**
//	 * SQL执行效率插件
//	 */
//	@Bean
//	@Profile({"dev"})// 设置 dev test 环境开启
//	public PerformanceInterceptor performanceInterceptor() {
//		PerformanceInterceptor pi = new PerformanceInterceptor();
//		return pi;
//	}

}
