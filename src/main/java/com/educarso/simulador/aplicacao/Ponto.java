package com.educarso.simulador.aplicacao;

import java.awt.Color;

import lombok.Data;

@Data
public class Ponto {
	
	public Ponto(int x, int y, Processo processo) {
		super();
		this.x = x;
		this.y = y;
		this.processo = processo;
	}
	private int x;
	private int y;
	private Processo processo;

}
