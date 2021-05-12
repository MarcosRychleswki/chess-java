package Aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.ExceptionXadrez;
import Xadrez.PartidaXadrez;
import Xadrez.Pe�aXadrez;
import Xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<Pe�aXadrez> capturadas = new ArrayList<>();
		
		
		while(true) {
			try {
				
				Front.clearScreen();
				Front.printPartida(partidaXadrez, capturadas);
				System.out.println();
				System.out.println("origem: ");
				PosicaoXadrez origem = Front.lerPosicaoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				//Front.clearScreen();
				//Front.printTabuleiro(partidaXadrez.getPe�as(), movimentosPossiveis);
				System.out.println();
				System.out.println("destino: ");
				PosicaoXadrez destino = Front.lerPosicaoXadrez(sc);
				
				Pe�aXadrez pe�aCapturada = partidaXadrez.movimentoXadrez(origem, destino);
				
				if (pe�aCapturada != null) {
					capturadas.add(pe�aCapturada);
				}
				
			}
			catch (ExceptionXadrez e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		
		
		
		
	}

}
