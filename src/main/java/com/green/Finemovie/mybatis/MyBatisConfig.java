package com.green.Finemovie.mybatis;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MyBatisConfig {
	
	@Bean
	SqlSessionTemplate sqlSession() throws Exception {
		
		return new SqlSessionTemplate(sqlSessionFactiory());
	}
	
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	SqlSessionFactory sqlSessionFactiory() throws Exception {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		
		factoryBean.setConfiguration(mybatisConfiguration());
		
		String locationPattern = "classpath:/static/mapper/**/*-mapper.xml";
		
		Resource[] mapperLocation = applicationContext.getResources(locationPattern);
		factoryBean.setMapperLocations(mapperLocation);
		
		return factoryBean.getObject();
	}
	
	@ConfigurationProperties(prefix = "mybatis.configuration")
	@Bean
	org.apache.ibatis.session.Configuration mybatisConfiguration() {
		
		return new org.apache.ibatis.session.Configuration();
		
	}


	@Bean
	DataSource dataSource() {
		
		return new HikariDataSource(hikariConfig());
		
	}
	
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	@Bean
	HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
}
