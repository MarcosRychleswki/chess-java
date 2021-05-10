package Xadrez;

import Jogo_de_tabuleiro.Peça;
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
	
	
	public PeçaXadrez movimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		Peça capturarPeça = mover(origem, destino);
		return (PeçaXadrez)capturarPeça;
	}
	
	private Peça mover(Posicao origem, Posicao destino) {
		Peça p = tabuleiro.removerPeça(origem);
		Peça peçaCapturada = tabuleiro.removerPeça(destino);
		tabuleiro.lugarPeça(p, destino);
		return peçaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temPeça(posicao)) {
			throw new ExceptionXadrez("Nao tem peça na posicao");
		}
	}
	
	
	
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPeça(char column, int row, PeçaXadrez peça) {
		tabuleiro.lugarPeça(peça, new PosicaoXadrez(column, row).toPosicao());
	}
	;
	private void inicioPartida() {
		colocarNovaPeça('a', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('h', 8, new Rei(tabuleiro, Cor.BLACK));
		
	}

	
	
	
	
	
	
	
	
	
}
