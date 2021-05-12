package Aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Xadrez.Cor;
import Xadrez.PartidaXadrez;
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
	
	
	public static void printPartida(PartidaXadrez partidaXadrez, List<PeçaXadrez> capturada) {
		printTabuleiro(partidaXadrez.getPeças());
		System.out.println();
		printPeçaCapturada(capturada);
		System.out.println();
		System.out.println("Turno : " + partidaXadrez.getTurno());
		System.out.println("Esperando a jogada do jogador : " + partidaXadrez.getJogadorAtual());
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
	
//	public static void printTabuleiro(PeçaXadrez[][] peças, boolean[][] movimentosPossiveis) {
//		for (int i=0; i<peças.length; i++) {
//			System.out.print((8 - i) + " ");
//			for (int j = 0; j<peças.length; j++) {
//				printPeça(peças[i][j]);
//			}
//			System.out.println();	
//		}
//		
//		System.out.println("  a b c d e f g h");
//		
//	}
	

	
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
	
	
	private static void printPeçaCapturada(List<PeçaXadrez> capturada) {
		List<PeçaXadrez> brancas = capturada.stream().filter(x -> x.getCor() == Cor.WHITE).collect(Collectors.toList());
		List<PeçaXadrez> pretas = capturada.stream().filter(x -> x.getCor() == Cor.BLACK).collect(Collectors.toList());
		System.out.println("Peças capturadas: ");
		System.out.print("Brancas ");
		System.out.println(Arrays.toString(brancas.toArray()));
		System.out.print("Pretas ");
		System.out.println(Arrays.toString(pretas.toArray()));

	}
	
	
	
	
	
}	
	
	


