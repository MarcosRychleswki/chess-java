package Xadrez.pe�as;

import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Pe�aXadrez;

public class Rei2 extends Pe�aXadrez{
	
	public Rei2(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "r";
	}
	
	@Override
	public boolean[][] movimentosPossiveis(){
		boolean [][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		return mat;
	}

}