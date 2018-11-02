package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessExpection;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch mat= new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		while (true){
			try {
					UI.clearScreen();
					UI.printMatch(mat,captured);
					System.out.println();
					System.out.print("Source: ");
					ChessPosition source = UI.readChessPosition(sc);
					
					boolean[][] possibleMoves = mat.possibleMoves(source);
					UI.clearScreen();
					UI.printBoard(mat.getPieces(), possibleMoves);
					
					System.out.println();
					System.out.print("Target: ");
					ChessPosition target = UI.readChessPosition(sc);
					
					ChessPiece capturedPiece = mat.performChessMove(source, target);
					
					if(capturedPiece != null) {
						captured.add(capturedPiece);
					}
				}
			
			catch(ChessExpection e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
