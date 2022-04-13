package com.imd.cartao_credito.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	//configuracao do bd de leitura/gravacao
	//dos metadados do Spring Batch
	//
	@Primary
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource springDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	//configuracao do bd para leitura/gravacao
	//de uso da aplicacao
	@Bean
	@ConfigurationProperties(prefix="app.datasource")
	public DataSource appDataSource() {
		return DataSourceBuilder.create().build();
	}


}
