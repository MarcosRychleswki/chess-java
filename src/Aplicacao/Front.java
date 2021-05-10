package Aplicacao;

import Xadrez.Cor;
import Xadrez.PeçaXadrez;

public class Front {
	
	
	

	
	
	
	
	
	public static void printTabuleiro(PeçaXadrez[][] peças) {
		for (int i=0; i<peças.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j<peças.length; j++) {
				printPeça(peças[i][j]);
			}
			System.out.println();	
		}
		
		System.out.println("  a b c d e f g h");
		
	}
	

	
	private static void printPeça(PeçaXadrez peça) {
	if (peça == null) {
		System.out.print("-");
	}
	else {
		if (peça.getCor() == Cor.WHITE) {
            System.out.print( peça );
        }
		else {
			System.out.print( peça);
        }
	}
	System.out.print(" ");
	}
	
}	
	
	


