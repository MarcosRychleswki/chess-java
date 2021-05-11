package Xadrez;

import Jogo_de_tabuleiro.Pe�a;
import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;

public abstract class Pe�aXadrez extends Pe�a {
	
	private Cor cor;

	public Pe�aXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	protected boolean pe�aOponente(Posicao posicao) {
		Pe�aXadrez p = (Pe�aXadrez)getTabuleiro().pe�a(posicao);
        return p != null && p.getCor() != cor;
    }


}
