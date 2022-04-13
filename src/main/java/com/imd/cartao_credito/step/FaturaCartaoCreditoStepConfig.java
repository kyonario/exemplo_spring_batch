package com.imd.cartao_credito.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imd.cartao_credito.dominio.FaturaCartaoCredito;

@Configuration
public class FaturaCartaoCreditoStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step faturaCartaoCreditoStep(
		ItemReader<FaturaCartaoCredito> lerTransacoesReader,
		ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> carregarDadosClienteProcessor,
		ItemWriter<FaturaCartaoCredito> escreverFaturaCartaoCredito) {
		
		return stepBuilderFactory
				.get("faturaCartaoCreditoStep")
				.<FaturaCartaoCredito, FaturaCartaoCredito> chunk(1) // o tamanho do chunk será um, por que a aplicação vai gerar um arquivo para por cliente
				.reader(lerTransacoesReader) //ler os registros das tabelas, no banco de dados
				.processor(carregarDadosClienteProcessor) //carregar os dados do cliente de cada transação
				.writer(escreverFaturaCartaoCredito) // vai escrever a fatura em arquivos
				.build();
			
		}
	
	}

