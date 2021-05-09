package Xadrez;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.pe�as.Rei;
import Xadrez.pe�as.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicioPartida();
	}

	public Pe�aXadrez[][] getPe�as() {

		Pe�aXadrez[][] mat = new Pe�aXadrez[tabuleiro.getRows()][tabuleiro.getColumns()];
		for (int i = 0; i < tabuleiro.getRows(); i++) {
			for (int j = 0; j < tabuleiro.getColumns(); j++) {
				mat[i][j] = (Pe�aXadrez) tabuleiro.pe�a(i, j);
			}
		}
		
		return mat;
	}
	
	private void inicioPartida() {
		tabuleiro.lugarPe�a(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.lugarPe�a(new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.lugarPe�a(new Rei(tabuleiro, Cor.WHITE), new Posicao(7, 4));
	}

}
