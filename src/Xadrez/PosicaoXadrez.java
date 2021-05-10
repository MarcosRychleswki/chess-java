package Xadrez;

import Jogo_de_tabuleiro.Posicao;

public class PosicaoXadrez {
	
	private char column;
	private int row;
	public PosicaoXadrez(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ExceptionXadrez("valores validos de a1 ate h8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}

	// formula para conversao
	// matrix_row == 8 - row 
	// matrix_column == column - 'a'
	// codigo de 'a' = 0
	protected Posicao toPosicao(){
		return new Posicao(8 - row, column - 'a');
	}
	
	// retorna a forma inversa do metodo toPosicao()
	protected static PosicaoXadrez fromPosicao(Posicao posicao) {
		return new PosicaoXadrez((char)('a' + posicao.getColumn()), 8 - posicao.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
	

}
