package com.xu.springbootdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 装配设置数据库
 * @author enhua
 *
 */
@Configuration
public class DataSourceConfig {
	//定义datasource bean
	@Bean(name = "zhqyDB")
	//配置文件的属性值
	@ConfigurationProperties(prefix="spring.datasource.zhqy")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "workmapDB")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.workmap")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	//定义jdbctemplate bean
	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
			@Qualifier("zhqyDB") DataSource dataSource) {//引用database
		return new JdbcTemplate(dataSource);
	}
	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(
			@Qualifier("workmapDB") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
