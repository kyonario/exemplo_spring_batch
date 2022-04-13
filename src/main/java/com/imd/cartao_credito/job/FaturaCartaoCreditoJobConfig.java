package com.imd.cartao_credito.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FaturaCartaoCreditoJobConfig {
	
	//fazendo o uso da injeção de dependencia na classe para uso do método
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	//Pondo anotação para o método ficar visivel no contexto da aplicação
	@Bean
	public Job faturaCartaoCreditoJob(Step faturaCartaoCreditoStep) {
		return jobBuilderFactory
				.get("faturaCartaoCreditoStep")
				.start(faturaCartaoCreditoStep) // determinando para o Job o Step que será executado, para essa aplicação só precisaremos de um
				.incrementer(new RunIdIncrementer()) // possibilitar reexecutar o mesmo procedimento várias vezes
				.build();
		
	}
}
