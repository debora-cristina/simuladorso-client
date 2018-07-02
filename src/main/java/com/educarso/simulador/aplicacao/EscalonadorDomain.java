package com.educarso.simulador.aplicacao;

import java.util.List;

import lombok.Data;

@Data
public class EscalonadorDomain {
	private String politica;
	private ConfigurarPolitica configuracao;
	private List<Processo> listaProcessos;
	
	public EscalonadorDomain(){
		
	}
}
