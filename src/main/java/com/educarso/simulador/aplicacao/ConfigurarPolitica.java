package com.educarso.simulador.aplicacao;

import lombok.Data;

@Data
public class ConfigurarPolitica {

	private int contexto;
	private int fatiatempo;
	private int numeroNucleos;
	private static ConfigurarPolitica instance;

	ConfigurarPolitica() {

	}

	public ConfigurarPolitica(int contexto, int fatiatempo, int numeroNucleos) {
		this.contexto = contexto;
		this.fatiatempo = fatiatempo;
		this.numeroNucleos = numeroNucleos;
	}

	public static ConfigurarPolitica getInstance() {
		if (ConfigurarPolitica.instance == null) {
			ConfigurarPolitica.instance = new ConfigurarPolitica();
		}
		return ConfigurarPolitica.instance;
	}


}
