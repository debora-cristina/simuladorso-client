package com.educarso.simulador.aplicacao;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Desenhar {

	public static class Grid extends JPanel {

		private List<Ponto> fillCells = new ArrayList<Ponto>(25);
		private int pontos;
		private int x;
		private int y;
		private int largura;
		private int altura;
		private Color cor;
		private List<Cores> lista = new ArrayList<Cores>();

		public Grid() {

			// pontos
		}

		public Grid(int pontos, int largura, int altura) {
			fillCells = new ArrayList<Ponto>(25);
			// pontos = new ArrayList<Ponto>(25);
			this.pontos = pontos;
			this.largura = largura;
			this.altura = altura;
			// fillCells = new ArrayList<Ponto>(25);
		}

		@Override
		protected void paintComponent(Graphics g) {
			// super.paintComponent(g);
			int posNome=40;
			for (Cores c : lista) {
				g.drawString(c.getNomeProcesso(), 10, posNome);
				posNome= posNome + 40;
				
			}
			for (Ponto fillCell : fillCells) {
				int cellX = 80 + (fillCell.getX() * 20);
				int cellY = 10 + (fillCell.getY() * 40);
				g.clearRect(cellX, cellY, 20, 40);
				if (fillCell.getProcesso().getEstado().equals(Estado.PRONTO)) {
					g.setColor(Color.cyan);
				} else if (fillCell.getProcesso().getEstado().equals(Estado.EXECUTANDO)) {
					g.setColor(Color.blue);
				} else if (fillCell.getProcesso().getEstado().equals(Estado.ENCERRADO)) {
					g.setColor(Color.green);
				}
				// System.out.println(fillCell.getCor());
				g.fillRect(cellX, cellY, 20, 40);

			}

			int count = 10;
			int posX = 30;
			int posY = lista.size() * 40 + 30;

			g.setColor(g.getColor().BLACK);
			g.drawString("PRONTO", 50, posY +20);
			g.setColor(g.getColor().cyan);
			g.fillRect(10, posY, 20, 20);

			g.setColor(g.getColor().BLACK);
			g.drawString("EXECUTANDO", 40, posY + 45);
			g.setColor(g.getColor().blue);
			g.fillRect(10, posY + 25, 20, 20);

			g.setColor(g.getColor().BLACK);
			g.drawString("ENCERRADO", 40, posY + 65);
			g.setColor(g.getColor().green);
			g.fillRect(10, posY + 50, 20, 20);

			g.setColor(Color.BLACK);
			g.drawRect(80, 10, this.pontos * 20, lista.size() * 40);

			for (int i = 10; i <= lista.size() * 40; i += 40) {
				g.drawLine(80, i, (this.pontos * 20) + 80, i);
			}

			for (int i = 80; i <= this.pontos * 20 + 80; i += 20) {
				g.drawLine(i, 10, i, lista.size() * 40 + 10);
			}

			for (int i = 0; i < this.pontos; i++) {
				g.drawString("" + i, 85 + (i * 20), lista.size() * 40 + 30);
			}

		}

		public void fillCell(int x, int y, Processo p) {
			fillCells.add(new Ponto(x, y, p));
			repaint();
		}

		public void desenhaNomes(List<Cores> lista) {
			this.lista = lista;
			repaint();
		}
	}
}