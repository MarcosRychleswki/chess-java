package Xadrez;

import Jogo_de_tabuleiro.TabuleiroException;

public class ExceptionXadrez extends TabuleiroException{
	private static final long serialVersionUID = 1L;
	
	public ExceptionXadrez(String msg) {
		super(msg);
	}

}
