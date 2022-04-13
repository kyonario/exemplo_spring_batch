package com.imd.cartao_credito.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.imd.cartao_credito.dominio.Transacao;

public class FaturaCartaoCredito implements ItemStreamReader<FaturaCartaoCredito>{
	
	private ItemStreamReader<Transacao> delegate;
	private Transacao transacaoAtual;
	
	public FaturaCartaoCredito(ItemStreamReader<Transacao> delegate) {
		this.delegate = delegate;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		delegate.open(executionContext);
		
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		delegate.update(executionContext);
		
	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		delegate.close();
		
	}

	@Override
	public FaturaCartaoCredito read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
