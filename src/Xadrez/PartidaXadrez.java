package Xadrez;

import Jogo_de_tabuleiro.Pe�a;
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
	
	
	public Pe�aXadrez movimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		Pe�a capturarPe�a = mover(origem, destino);
		return (Pe�aXadrez)capturarPe�a;
	}
	
	private Pe�a mover(Posicao origem, Posicao destino) {
		Pe�a p = tabuleiro.removerPe�a(origem);
		Pe�a pe�aCapturada = tabuleiro.removerPe�a(destino);
		tabuleiro.lugarPe�a(p, destino);
		return pe�aCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temPe�a(posicao)) {
			throw new ExceptionXadrez("Nao tem pe�a na posicao");
		}
	}
	
	
	
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPe�a(char column, int row, Pe�aXadrez pe�a) {
		tabuleiro.lugarPe�a(pe�a, new PosicaoXadrez(column, row).toPosicao());
	}
	;
	private void inicioPartida() {
		colocarNovaPe�a('a', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPe�a('h', 8, new Rei(tabuleiro, Cor.BLACK));
		
	}

	
	
	
	
	
	
	
	
	
}
