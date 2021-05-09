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
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPe�a(char column, int row, Pe�aXadrez pe�a) {
		tabuleiro.lugarPe�a(pe�a, new PosicaoXadrez(column, row).toPosicao());
	}
	
	private void inicioPartida() {
		colocarNovaPe�a('b', 6, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPe�a('e', 8,new Rei(tabuleiro, Cor.BLACK));
		colocarNovaPe�a('e', 1,new Rei(tabuleiro, Cor.WHITE));
	}

}
