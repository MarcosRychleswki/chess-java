package Xadrez;

import Jogo_de_tabuleiro.Peça;
import Jogo_de_tabuleiro.Tabuleiro;

public class PeçaXadrez extends Peça {
	
	private Cor cor;

	public PeçaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}



}
