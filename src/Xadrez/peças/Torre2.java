package Xadrez.peças;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PeçaXadrez;

public class Torre2 extends PeçaXadrez{

	public Torre2(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "t";
	}
	
	@Override
	public boolean[][] movimentosPossiveis(){
		boolean [][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Posicao p = new Posicao(0, 0);
		
		//acima
		p.setValores(posicao.getRow() - 1, posicao.getColumn());
		//enquanto tiver casas vazias
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeça(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()-1);
		}
		// teste para ver se tem peça adversaria
		if (getTabuleiro().posicaoExiste(p) && peçaOponente(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		//esquerda
		p.setValores(posicao.getRow(), posicao.getColumn() - 1);
		//enquanto tiver casas vazias
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeça(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()-1);
		}
		// teste para ver se tem peça adversaria
		if (getTabuleiro().posicaoExiste(p) && peçaOponente(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		//direita
		p.setValores(posicao.getRow(), posicao.getColumn() + 1);
		//enquanto tiver casas vazias
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeça(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn()+1);
		}
		// teste para ver se tem peça adversaria
		if (getTabuleiro().posicaoExiste(p) && peçaOponente(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		
		//para baixo
		p.setValores(posicao.getRow() + 1, posicao.getColumn());
		//enquanto tiver casas vazias
		while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeça(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow()+1);
		}
		// teste para ver se tem peça adversaria
		if (getTabuleiro().posicaoExiste(p) && peçaOponente(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		

		return mat;
	}	
	
}
