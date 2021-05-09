package Xadrez;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.peças.Rei;
import Xadrez.peças.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicioPartida();
	}

	public PeçaXadrez[][] getPeças() {

		PeçaXadrez[][] mat = new PeçaXadrez[tabuleiro.getRows()][tabuleiro.getColumns()];
		for (int i = 0; i < tabuleiro.getRows(); i++) {
			for (int j = 0; j < tabuleiro.getColumns(); j++) {
				mat[i][j] = (PeçaXadrez) tabuleiro.peça(i, j);
			}
		}
		
		return mat;
	}
	
	private void inicioPartida() {
		tabuleiro.lugarPeça(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.lugarPeça(new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.lugarPeça(new Rei(tabuleiro, Cor.WHITE), new Posicao(7, 4));
	}

}
