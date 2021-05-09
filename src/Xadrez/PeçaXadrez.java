package Xadrez;

import Jogo_de_tabuleiro.Pe�a;
import Jogo_de_tabuleiro.Tabuleiro;

public class Pe�aXadrez extends Pe�a {
	
	private Cor cor;

	public Pe�aXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}



}
