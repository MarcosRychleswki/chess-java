package Xadrez.pe�as;

import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Pe�aXadrez;

public class Torre extends Pe�aXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	
	
}
