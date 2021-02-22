package com.spring.ionic.domain;

import javax.persistence.Entity;

import com.spring.ionic.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	
	private Integer numerDeParcelas;

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {

		this.numerDeParcelas = numeroDeParcelas;
		
	
	}

	public Integer getNumerDeParcelas() {
		return numerDeParcelas;
	}

	public void setNumerDeParcelas(Integer numerDeParcelas) {
		this.numerDeParcelas = numerDeParcelas;
	}
	
	
}
