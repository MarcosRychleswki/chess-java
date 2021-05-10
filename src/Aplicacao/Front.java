package Aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.Cor;
import Xadrez.PeçaXadrez;
import Xadrez.PosicaoXadrez;

public class Front {
	
	// metodo gambiarra linda
	public static void clearScreen() { 
		for (int i = 0; i < 50; ++i) System.out.println ();
		} 
	
	
	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new PosicaoXadrez(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("erro lendo posicao do xadres, valores validos de a1 ate "
					+ "h8, aperte enter para continuar");
		}
	}
	
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
	
	


