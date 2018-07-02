package com.educarso.simulador.aplicacao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Processo  {

	private String nomeProcesso;
	private int tempoChegada;
	private int tempoCpu;
	private Estado estado;
	//private int waitingTime;
	private int prioridade;
	private int tempoExecucao;

	Processo() {
		 
	}

	public Processo(String id, int tempoChegada, int tempoCpu, int prioridade) {
		this.nomeProcesso = id;
		this.tempoChegada = tempoChegada;
		this.tempoCpu = tempoCpu;
		this.prioridade = prioridade;
		this.estado = Estado.CRIADO;
	}

	Processo(Processo processo) {
		this(processo.nomeProcesso, processo.tempoChegada, processo.tempoCpu,
				processo.prioridade);

	}

	

}
