package com.xu.springbootdemo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 获取数据库
 * @author enhua
 *
 */
//@Component
//public class DaoUtils {
//	@Autowired
//	@Qualifier("primaryJdbcTemplate")
//	private JdbcTemplate jdbcTemplate1;
//	@Autowired
//	@Qualifier("secondaryJdbcTemplate")
//	private JdbcTemplate jdbcTemplate2;
//	
//	public  JdbcTemplate getprimaryJdbcTemplate() {
//		return jdbcTemplate1;
//	}
//	public  JdbcTemplate getsecondaryJdbcTemplate() {
//		return jdbcTemplate2;
//	}
//}
