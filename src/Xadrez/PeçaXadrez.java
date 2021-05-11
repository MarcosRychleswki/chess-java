package Xadrez;

import Jogo_de_tabuleiro.Peça;
import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;

public abstract class PeçaXadrez extends Peça {
	
	private Cor cor;

	public PeçaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	protected boolean peçaOponente(Posicao posicao) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peça(posicao);
        return p != null && p.getCor() != cor;
    }


}
