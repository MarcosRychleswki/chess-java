package Aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Xadrez.Cor;
import Xadrez.PartidaXadrez;
import Xadrez.Pe�aXadrez;
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
	
	
	public static void printPartida(PartidaXadrez partidaXadrez, List<Pe�aXadrez> capturada) {
		printTabuleiro(partidaXadrez.getPe�as());
		System.out.println();
		printPe�aCapturada(capturada);
		System.out.println();
		System.out.println("Turno : " + partidaXadrez.getTurno());
		System.out.println("Esperando a jogada do jogador : " + partidaXadrez.getJogadorAtual());
	}
	
	
	
	
	public static void printTabuleiro(Pe�aXadrez[][] pe�as) {
		for (int i=0; i<pe�as.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j<pe�as.length; j++) {
				printPe�a(pe�as[i][j]);
			}
			System.out.println();	
		}
		
		System.out.println("  a b c d e f g h");
		
	}
	
//	public static void printTabuleiro(Pe�aXadrez[][] pe�as, boolean[][] movimentosPossiveis) {
//		for (int i=0; i<pe�as.length; i++) {
//			System.out.print((8 - i) + " ");
//			for (int j = 0; j<pe�as.length; j++) {
//				printPe�a(pe�as[i][j]);
//			}
//			System.out.println();	
//		}
//		
//		System.out.println("  a b c d e f g h");
//		
//	}
	

	
	private static void printPe�a(Pe�aXadrez pe�a) {
	if (pe�a == null) {
		System.out.print("-");
	}
	else {
		if (pe�a.getCor() == Cor.WHITE) {
            System.out.print( pe�a );
        }
		else {
			System.out.print( pe�a);
        }
	}
	System.out.print(" ");
	}
	
	
	private static void printPe�aCapturada(List<Pe�aXadrez> capturada) {
		List<Pe�aXadrez> brancas = capturada.stream().filter(x -> x.getCor() == Cor.WHITE).collect(Collectors.toList());
		List<Pe�aXadrez> pretas = capturada.stream().filter(x -> x.getCor() == Cor.BLACK).collect(Collectors.toList());
		System.out.println("Pe�as capturadas: ");
		System.out.print("Brancas ");
		System.out.println(Arrays.toString(brancas.toArray()));
		System.out.print("Pretas ");
		System.out.println(Arrays.toString(pretas.toArray()));

	}
	
	
	
	
	
}	
	
	


