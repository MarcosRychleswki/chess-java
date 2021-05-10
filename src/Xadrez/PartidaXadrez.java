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
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPeça(char column, int row, PeçaXadrez peça) {
		tabuleiro.lugarPeça(peça, new PosicaoXadrez(column, row).toPosicao());
	}
	
	private void inicioPartida() {
		colocarNovaPeça('b', 6, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('e', 8, new Rei(tabuleiro, Cor.BLACK));
		colocarNovaPeça('e', 1, new Rei(tabuleiro, Cor.WHITE));
		colocarNovaPeça('c', 1, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('c', 2, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('d', 2, new Torre(tabuleiro, Cor.WHITE));
	    colocarNovaPeça('e', 2, new Torre(tabuleiro, Cor.WHITE));
	    colocarNovaPeça('d', 1, new Rei(tabuleiro, Cor.WHITE));

	    colocarNovaPeça('c', 7, new Rei(tabuleiro, Cor.BLACK));
	    colocarNovaPeça('c', 7, new Torre(tabuleiro, Cor.BLACK));
	    colocarNovaPeça('c', 8, new Torre(tabuleiro, Cor.BLACK));
	    colocarNovaPeça('d', 7, new Torre(tabuleiro, Cor.BLACK));
	    colocarNovaPeça('e', 7, new Torre(tabuleiro, Cor.BLACK));
	    colocarNovaPeça('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}

	
	
	
	
	
	
	
	
	
}
