package Jogo_de_tabuleiro;

public class Tabuleiro {
	
	private int rows;
	private int columns;
	private Pe�a[][] pe�a;
	
	
	public Tabuleiro(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pe�a = new Pe�a[rows][columns];
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
	
	
	
	

}
