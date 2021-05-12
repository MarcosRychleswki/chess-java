package Xadrez;

import Jogo_de_tabuleiro.Pe�a;
import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.pe�as.Rei;
import Xadrez.pe�as.Rei2;
import Xadrez.pe�as.Torre;
import Xadrez.pe�as.Torre2;

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

	public Pe�aXadrez[][] getPe�as() {

		Pe�aXadrez[][] mat = new Pe�aXadrez[tabuleiro.getRows()][tabuleiro.getColumns()];
		for (int i = 0; i < tabuleiro.getRows(); i++) {
			for (int j = 0; j < tabuleiro.getColumns(); j++) {
				mat[i][j] = (Pe�aXadrez) tabuleiro.pe�a(i, j);
			}
		}
		
		return mat;
	}
	
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.toPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.pe�a(posicao).movimentosPossiveis();
	}
	
	
	
	public Pe�aXadrez movimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Pe�a capturarPe�a = mover(origem, destino);
		proximoTurno();
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
		if (jogadorAtual != ((Pe�aXadrez)tabuleiro.pe�a(posicao)).getCor()) {
			throw new ExceptionXadrez("Essa pe�a nao e sua");
		}
		if (!tabuleiro.pe�a(posicao).eQMP()) {
			throw new ExceptionXadrez("nao existe movimentos possiveis para a pe�a, aperte enter");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.pe�a(origem).movimentoPossivel(destino)) {
			throw new ExceptionXadrez("Pe�a escolhida nao pode se mover para a posicao de destino");
		}
	}
	
	// troca de turno
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}
	
	
	
	
	
	
	// metodo para receber as coordenadas do xadrez
	private void colocarNovaPe�a(char column, int row, Pe�aXadrez pe�a) {
		tabuleiro.lugarPe�a(pe�a, new PosicaoXadrez(column, row).toPosicao());
	}
	
	private void inicioPartida() {
		colocarNovaPe�a('b', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPe�a('e', 7, new Rei(tabuleiro, Cor.WHITE));
		colocarNovaPe�a('d', 8, new Torre(tabuleiro, Cor.WHITE));
		colocarNovaPe�a('c', 6, new Rei(tabuleiro, Cor.WHITE));
		
		colocarNovaPe�a('b', 1, new Rei2(tabuleiro, Cor.BLACK));
		colocarNovaPe�a('d', 1, new Torre2(tabuleiro, Cor.BLACK));
		colocarNovaPe�a('e', 2, new Rei2(tabuleiro, Cor.BLACK));
		colocarNovaPe�a('g', 3, new Torre2(tabuleiro, Cor.BLACK));
	}

	
	
	
	
	
	
	
	
	
}
