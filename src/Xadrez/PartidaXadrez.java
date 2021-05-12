package Xadrez;

import Jogo_de_tabuleiro.Peça;
import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.peças.Rei;
import Xadrez.peças.Rei2;
import Xadrez.peças.Torre;
import Xadrez.peças.Torre2;

public class PartidaXadrez {

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.WHITE;
		inicioPartida();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Cor getJogadorAtual() {
		return jogadorAtual;
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
	
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.toPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peça(posicao).movimentosPossiveis();
	}
	
	
	
	public PeçaXadrez movimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peça capturarPeça = mover(origem, destino);
		proximoTurno();
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
		if (jogadorAtual != ((PeçaXadrez)tabuleiro.peça(posicao)).getCor()) {
			throw new ExceptionXadrez("Essa peça nao e sua");
		}
		if (!tabuleiro.peça(posicao).eQMP()) {
			throw new ExceptionXadrez("nao existe movimentos possiveis para a peça, aperte enter");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peça(origem).movimentoPossivel(destino)) {
			throw new ExceptionXadrez("Peça escolhida nao pode se mover para a posicao de destino");
		}
	}
	
	// troca de turno
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}
	
	
	
	
	
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPeça(char column, int row, PeçaXadrez peça) {
		tabuleiro.lugarPeça(peça, new PosicaoXadrez(column, row).toPosicao());
	}
	
	private void inicioPartida() {
		colocarNovaPeça('b', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('e', 7, new Rei(tabuleiro, Cor.WHITE));
		colocarNovaPeça('d', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPeça('c', 6, new Rei(tabuleiro, Cor.WHITE));
		
		colocarNovaPeça('b', 1, new Rei2(tabuleiro, Cor.BLACK));
		colocarNovaPeça('d', 1, new Torre2(tabuleiro, Cor.BLACK));
		colocarNovaPeça('e', 2, new Rei2(tabuleiro, Cor.BLACK));
		colocarNovaPeça('g', 3, new Torre2(tabuleiro, Cor.BLACK));
	}

	
	
	
	
	
	
	
	
	
}
