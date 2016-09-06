package com.backbase.codechallenge.kalah.controller;

import com.backbase.codechallenge.kalah.model.KalahGame;

public class KalahController {

	public static void main (String[]args){
		
		KalahGame game = new KalahGame("Player1","Player2",0);
		game.makeMove(0);
		game.getGameState().printBoard();
		System.out.println();
		game.makeMove(6);
		game.getGameState().printBoard();
		System.out.println();
		game.makeMove(3);
		game.getGameState().printBoard();
		System.out.println();
		game.makeMove(9);
		game.getGameState().printBoard();
	}
}
