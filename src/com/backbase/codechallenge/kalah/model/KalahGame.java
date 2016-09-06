package com.backbase.codechallenge.kalah.model;

import java.util.ArrayList;
import java.util.List;

public class KalahGame {

	private State gameState;
	private KalahPlayer player1;
	private KalahPlayer player2;

	public KalahGame(String player1Name, String player2Name,
			int currentPlayerIndex) {

		initializeGame(player1Name, player2Name, currentPlayerIndex);
	}

	private void initializeGame(String player1Name, String player2Name,
			int currentPlayerIndex) {

		int[] initBoard = { 0, 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6 };

		player1 = new KalahPlayer();
		player2 = new KalahPlayer();

		List<KalahPlayer> players = new ArrayList<KalahPlayer>();
		players.add(player1);
		players.add(player2);

		player1.setName(player1Name);
		player2.setName(player2Name);

		gameState = new State();
		gameState.setBoard(initBoard);
		gameState.setPlayers(players);
		gameState.setPlayerToMoveNum(currentPlayerIndex);
	}

	public void makeMove(int pitIndex) {
		int playerKalah, opponentKalah;
		int stones;

		// Decide which kalah belongs to the current player
		playerKalah = gameState.getPlayerToMoveNum() * 7;
		opponentKalah = 7 - playerKalah;

		// Make the move
		stones = gameState.getBoard()[pitIndex];
		gameState.removeAllStoneAtChosenPit(pitIndex);

		while (stones > 0) {
			pitIndex--;
			if (pitIndex == -1) // Handle wrapping around
				pitIndex = 13;
			if (pitIndex != opponentKalah) // Nothing dropped in opponent's
											// kalah
			{
				gameState.addOneStoneInThePit(pitIndex);
				; // Drop a stone in the pit
				stones--;
			}
		}

		// Handle move-again and captures

		if (pitIndex != playerKalah) { // If end in own kalah, move again
			if ((gameState.getBoard()[pitIndex] == 1)
					&& (gameState.getBoard()[14 - pitIndex] > 0)
					&& ((gameState.getPlayerToMoveNum() == 0 && (pitIndex < 7)) || (gameState
							.getPlayerToMoveNum() == 1 && (pitIndex > 7)))) {
				int boardValue = gameState.getBoard()[playerKalah]
						+ gameState.getBoard()[14 - pitIndex] + 1;
				gameState.updateBoardByPitIndex(playerKalah, boardValue);
				gameState.updateBoardByPitIndex(pitIndex, 0);
				gameState.updateBoardByPitIndex(14 - pitIndex, 0);
			}
			gameState.setPlayerToMoveNum(1 - gameState.getPlayerToMoveNum()); // Switch
																				// player
		}
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}
	
	
}
