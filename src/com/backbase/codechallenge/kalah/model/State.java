package com.backbase.codechallenge.kalah.model;

import java.util.List;

public class State {
	private int[] board;
	private int playerToMoveNum;
	private List<KalahPlayer> players;

	public int[] getBoard() {

		return board;
	}

	public void setBoard(int[] board) {

		this.board = board;
	}

	public int getPlayerToMoveNum() {

		return playerToMoveNum;
	}

	public void setPlayerToMoveNum(int playerToMoveNum) {

		this.playerToMoveNum = playerToMoveNum;
	}

	public List<KalahPlayer> getPlayers() {

		return players;
	}

	public void setPlayers(List<KalahPlayer> players) {

		this.players = players;
	}

	public void removeAllStoneAtChosenPit(int pitIndex) {

		board[pitIndex] = 0;
	}

	public void addOneStoneInThePit(int pitIndex) {

		board[pitIndex]++;
	}

	public void updateBoardByPitIndex(int pitIndex, int boardValue) {

		board[pitIndex] = boardValue;
	}
	public void printBoard(){
		
		for(int i = 0; i <7;i++){
			System.out.print(board[i]);
		}
		System.out.println();
		for(int i = 13; i >= 7;i--){
			System.out.print(board[i]);
		}
		System.out.println();
		System.out.println("kalah player1 is : " + board[0]);
		System.out.println("kalah player2 is: " + board[7]);
		if(playerToMoveNum == 0)
			System.out.println("It's player 1 turn");
		else
			System.out.println("It's player 2 turn");
	}
}
