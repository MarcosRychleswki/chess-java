package Aplicacao;

import java.util.Scanner;

import Jogo_de_tabuleiro.Posicao;
import Jogo_de_tabuleiro.Tabuleiro;
import Xadrez.PartidaXadrez;
import Xadrez.Pe�aXadrez;
import Xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		
		while(true) {
			
			Front.printTabuleiro(partidaXadrez.getPe�as());
			System.out.println();
			System.out.println("origem: ");
			PosicaoXadrez origem = Front.lerPosicaoXadrez(sc);
			
			
			System.out.println();
			System.out.println("destino: ");
			PosicaoXadrez destino = Front.lerPosicaoXadrez(sc);
			
			Pe�aXadrez pe�aCapturada = partidaXadrez.movimentoXadrez(origem, destino);
		}
		
		
		
		
		
	}

}
