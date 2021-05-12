package Xadrez.peças;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PeçaXadrez;

public class Rei extends PeçaXadrez{
	
	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	private boolean podeMover(Posicao posicao) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peça(posicao);
		return p == null || p.getCor() != getCor();
	}
	
	@Override
	public boolean[][] movimentosPossiveis(){
		boolean [][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Posicao p = new Posicao(0, 0);
		
		
		//acima
		p.setValores(posicao.getRow() - 1, posicao.getColumn());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//abaixo
		p.setValores(posicao.getRow() + 1, posicao.getColumn());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//esquerda
		p.setValores(posicao.getRow(), posicao.getColumn() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//direita
		p.setValores(posicao.getRow(), posicao.getColumn() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//noroeste
		p.setValores(posicao.getRow() - 1, posicao.getColumn() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//nordeste
		p.setValores(posicao.getRow() - 1, posicao.getColumn() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		
		//sudoeste
		p.setValores(posicao.getRow() + 1, posicao.getColumn() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		//sudeste
		p.setValores(posicao.getRow() + 1, posicao.getColumn() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		
		return mat;
	}
	
	
	
	
	

}
