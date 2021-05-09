package Aplicacao;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.PartidaXadrez;

public class Programa {

	public static void main(String[] args) {
		
	
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		Front.printTabuleiro(partidaXadrez.getPeças());
		
		
		
	}

}
