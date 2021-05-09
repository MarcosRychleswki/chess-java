package Jogo_de_tabuleiro;

public class Tabuleiro {
	
	private int rows;
	private int columns;
	private Pe�a[][] pe�as;
	
	
	public Tabuleiro(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pe�as = new Pe�a[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	// metodo para retornar uma pe�a dada a uma linha e coluna
	public Pe�a pe�a(int row, int column) {
		return pe�as[row][column];
	}
	
	// sobrecarga do metodo, retornar a pe�a pela posi�ao
	public Pe�a pe�a(Posicao posicao) {
		return pe�as[posicao.getRow()][posicao.getColumn()];
	}
	
	public void lugarPe�a(Pe�a pe�a, Posicao posicao) {
		pe�as[posicao.getRow()][posicao.getColumn()] = pe�a;
		pe�a.posicao = posicao;
	}
	

}
