package Xadrez.pe�as;

import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Pe�aXadrez;

public class Rei extends Pe�aXadrez{
	
	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

}
