package com.educarso.simulador.aplicacao;

import java.awt.Color;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cores {
	private String nomeProcesso;
	private int posicao;


	public Cores(String nomeProcesso, int posicao) {
		super();
		this.nomeProcesso = nomeProcesso;
		this.posicao = posicao;
	}

}
