package Jogo_de_tabuleiro;

public class Tabuleiro {
	
	private int rows;
	private int columns;
	private Pe�a[][] pe�as;
	
	
	public Tabuleiro(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new TabuleiroException("Erro ao criar: pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pe�as = new Pe�a[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}

	
	// metodo para retornar uma pe�a dada a uma linha e coluna
	public Pe�a pe�a(int row, int column) {
		if (!posicaoExiste(row, column)) {
			throw new TabuleiroException("A posi��o n�o est� no tabuleiro");
		}
		return pe�as[row][column];
	}
	
	// sobrecarga do metodo, retornar a pe�a pela posi�ao
	public Pe�a pe�a(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posi��o n�o est� no tabuleiro");
		}
		return pe�as[posicao.getRow()][posicao.getColumn()];
	}
	
	// colocar uma pe�a em uma posicao
	public void lugarPe�a(Pe�a pe�a, Posicao posicao) {
		if (temPe�a(posicao)) {
			throw new TabuleiroException("j� existe uma pe�a na posi��o" + posicao);
		}
		pe�as[posicao.getRow()][posicao.getColumn()] = pe�a;
		pe�a.posicao = posicao;
	}
	
	private boolean posicaoExiste(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getRow(), posicao.getColumn());
	}
	
	public boolean temPe�a(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posi��o n�o est� no tabuleiro");
		}
		return pe�a(posicao) != null;
	}

}
