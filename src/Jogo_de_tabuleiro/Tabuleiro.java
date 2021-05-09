package Jogo_de_tabuleiro;

public class Tabuleiro {
	
	private int rows;
	private int columns;
	private Peça[][] peças;
	
	
	public Tabuleiro(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new TabuleiroException("Erro ao criar: pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		peças = new Peça[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}

	
	// metodo para retornar uma peça dada a uma linha e coluna
	public Peça peça(int row, int column) {
		if (!posicaoExiste(row, column)) {
			throw new TabuleiroException("A posição não está no tabuleiro");
		}
		return peças[row][column];
	}
	
	// sobrecarga do metodo, retornar a peça pela posiçao
	public Peça peça(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posição não está no tabuleiro");
		}
		return peças[posicao.getRow()][posicao.getColumn()];
	}
	
	// colocar uma peça em uma posicao
	public void lugarPeça(Peça peça, Posicao posicao) {
		if (temPeça(posicao)) {
			throw new TabuleiroException("já existe uma peça na posição" + posicao);
		}
		peças[posicao.getRow()][posicao.getColumn()] = peça;
		peça.posicao = posicao;
	}
	
	private boolean posicaoExiste(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getRow(), posicao.getColumn());
	}
	
	public boolean temPeça(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("A posição não está no tabuleiro");
		}
		return peça(posicao) != null;
	}

}
