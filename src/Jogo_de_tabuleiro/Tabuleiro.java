package Jogo_de_tabuleiro;

public class Tabuleiro {
	
	private int rows;
	private int columns;
	private Peça[][] peças;
	
	
	public Tabuleiro(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		peças = new Peça[rows][columns];
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
	
	// metodo para retornar uma peça dada a uma linha e coluna
	public Peça peça(int row, int column) {
		return peças[row][column];
	}
	
	// sobrecarga do metodo, retornar a peça pela posiçao
	public Peça peça(Posicao posicao) {
		return peças[posicao.getRow()][posicao.getColumn()];
	}
	
	public void lugarPeça(Peça peça, Posicao posicao) {
		peças[posicao.getRow()][posicao.getColumn()] = peça;
		peça.posicao = posicao;
	}
	

}
