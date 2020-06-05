package jogoDaVelha;

import java.util.Scanner;

import java.util.Scanner;

public class JogoDaVelha {
	private int table[][] = new int[3][3];

	public JogoDaVelha() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = 0;
			}
		}
	}

	public void showGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int checkWinner() {
		for (int i = 0; i < 3; i++) {
			if ((table[i][0] == table[i][1]) &&
				(table[i][0] == table[i][2])) {
				if (table[i][0] != 0) {
					return table[i][0];
				}
			}
		}
		for (int j = 0; j < 3; j++) {
			if ((table[0][j] == table[1][j]) &&
				(table[0][j] == table[2][j]) &&
				(table[0][j] != 0)) {
				return table[0][j];
			}
		}
		if ((table[0][0] == table[1][1]) &&
			(table[0][0] == table[2][2]) &&
			(table[0][0] != 0)) {
			return table[0][0];
		}
		if ((table[0][2] == table[1][1]) &&
			(table[0][2] == table[2][0]) &&
			(table[0][2] != 0)) {
			return table[0][2];
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (table[i][j] == 0) {
					return 0;
				}
			}
		}
		return 3;
	}
	
	public boolean play(int jogador, int linha, int coluna) {
		if ((linha < 0) || (linha > 2)) {
			return false;
		}
		if ((coluna < 0) || (coluna > 2)) {
			return false;
		}
		if (table[linha][coluna] != 0) {
			return false;
		}
		table[linha][coluna] = jogador;
		return true;
	}

	public static void main(String[] argumentos) {
		Scanner scan = new Scanner(System.in);
		JogoDaVelha table = new JogoDaVelha();
		int jogador = 1;
		int winner = table.checkWinner();
		table.showGame();
		while (winner == 0) {
			System.out.println("Jogador " + jogador);
			System.out.print("Linha: ");
			int linha = scan.nextInt();
			System.out.print("Coluna: ");
			int coluna = scan.nextInt();
			if (!table.play(jogador, linha-1, coluna-1)) {
				System.out.println("Jogada inválida...");
			} else {
				jogador = (jogador == 1) ? 2 : 1;
			}
			table.showGame();
			winner = table.checkWinner();
		}
		switch (winner) {
			case 1 :
				System.out.println("Vencedor jogador 1");
				break;
			case 2:
				System.out.println("Vencedor jogador 2");
				break;
			case 3:
				System.out.println("Empate");
				break;
		}
	}
}