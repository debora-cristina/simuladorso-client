package com.educarso.simulador.aplicacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.educarso.simulador.aplicacao.Processo;

import lombok.Data;
@Data
public class MapaProcessos {
	private int tempo;
	private Map<Estado,List<Processo>> processos = new HashMap<Estado,List<Processo>>();
	
	public MapaProcessos(){
		
	}
	public MapaProcessos(int tempo, Map<Estado, List<Processo>> processos) {
		super();
		this.tempo = tempo;
		this.processos = processos;
	}
	
	

	

}
