package com.educarso.simulador.aplicacao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import com.educarso.simulador.aplicacao.Desenhar.Grid;
import com.educarso.simulador.client.EscalonadorClient;
import com.educarso.simulador.client.ExecutarClient;

public class Aplicacao {
	private static int posicao = 0;

	public static boolean retornaNomes(List<Cores> processos, String nomeProcesso) {

		for (Cores p : processos) {
			if (p.getNomeProcesso().equals(nomeProcesso)) {
				return true;
			}
		}
		return false;
	}

	public static Color randomColor() {
		Random random = new Random();
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		return new Color(red, green, blue);
	}

	public static void main(String[] args) {

		EscalonadorClient cliente = new EscalonadorClient();

		EscalonadorDomain escalonador = cliente.listar();

		System.out.print("Escalonador" + escalonador.getPolitica());

		ExecutarClient executar = new ExecutarClient();
		executar.salvarProcesso(new Processo("00", 0, 7, 2));
		executar.salvarProcesso(new Processo("01", 3, 4, 1));
		executar.salvarProcesso(new Processo("02", 3, 5, 0));


		EscalonadorDomain escalona = new EscalonadorDomain();

		escalona.setPolitica("PRIORIDADE");
		escalona.setListaProcessos(executar.getProcesso());
		escalona.setConfiguracao(new ConfigurarPolitica(0, 0, 0));
		executar.salvar(escalona);

		String localizacao = cliente.salvar(escalona);

		System.out.println("URI do livro salvo: " + localizacao);

		// Desenhar desenha = new Desenhar();
		JFrame window = new JFrame();
		window.setSize(1024, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		executar.listar();
		Grid grid = new Grid(executar.getMapa().size(), 20, 20);
		window.add(grid);
		window.setVisible(true);

		// window.setVisible(true);

		List<Cores> cores = new ArrayList<Cores>();

		for (MapaProcessos m : executar.getMapa()) {
			System.out.print(m.getTempo());
			for (Map.Entry<Estado, List<Processo>> entry : m.getProcessos().entrySet()) {
				// desenha.preencher(0, 0);

				for (Processo p : entry.getValue()) {
					if (!retornaNomes(cores, p.getNomeProcesso())) {
						cores.add(new Cores(p.getNomeProcesso(), posicao));
						posicao++;
					}

				}
			}
		}

		grid.desenhaNomes(cores);
		int posicao = 0;

		for (MapaProcessos m : executar.getMapa()) {
			// System.out.print(m.getTempo());
			for (Map.Entry<Estado, List<Processo>> entry : m.getProcessos().entrySet()) {
				// desenha.preencher(0, 0);

				for (Cores c : cores) {
					for (Processo p : entry.getValue()) {

						if (p.getEstado().equals(Estado.EXECUTANDO)) {
							if (p.getNomeProcesso().equals(c.getNomeProcesso())) {
								grid.fillCell((m.getTempo()), c.getPosicao(), p);
							}
							// System.out.println(p.getNomeProcesso() + "
							// EXECUTANDO " + m.getTempo());

						} else if (p.getEstado().equals(Estado.PRONTO)) {

							if (p.getNomeProcesso().equals(c.getNomeProcesso())) {
								grid.fillCell(0 + (m.getTempo()), c.getPosicao(), p);
							}
							// System.out.println(p.getNomeProcesso() + " PRONTO
							// " + m.getTempo());

						} else if (p.getEstado().equals(Estado.ENCERRADO)) {
							if (p.getNomeProcesso().equals(c.getNomeProcesso())) {
								grid.fillCell((m.getTempo()), c.getPosicao(), p);
							}
							// System.out.println(p.getNomeProcesso() + " ENCERRADO " + m.getTempo());
						}
					}
				}
				// System.out.println(" ");
			}
		}

	}

}
