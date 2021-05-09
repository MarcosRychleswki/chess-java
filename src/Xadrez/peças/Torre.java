package Xadrez.peças;

import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PeçaXadrez;

public class Torre extends PeçaXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	
	
}
