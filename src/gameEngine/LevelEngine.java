package gameEngine;

import java.util.ArrayList;

import levelPieces.AdvancePiece;
import levelPieces.CoinPiece;
import levelPieces.CoinThrowerPiece;
import levelPieces.GamePiece;
import levelPieces.HurdlePiece;
import levelPieces.MonsterPiece;
import levelPieces.MovingCoinPiece;
import levelPieces.SentryGunPiece;
import levelPieces.SpikesPiece;	

public class LevelEngine {
	
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	public LevelEngine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void createLevel(int levelNum) {
		// clear board and piece lists
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		// call level building methods
		if (levelNum == 1) {
			level1();
		} else if (levelNum == 2) {
			level2();
		}
		
		// populate game lists
		for (Drawable piece : board) {
			if (piece instanceof GamePiece) {
				interactingPieces.add((GamePiece) piece);
			}
			
			if (piece instanceof Moveable) {
				movingPieces.add((Moveable) piece);
			}
		}
	}
	
	/**
	 * Instantiates level 1
	 */
	private void level1() {
		/*
		 * Level start state
		 * | |A| | |H| | |^| | |P| | | |^| | | |T| |o|
		 */
		playerStartLoc = 10;
		board[1] = new AdvancePiece(1);
		board[4] = new HurdlePiece();
		board[7] = new SpikesPiece(7);
		board[14] = new SpikesPiece(14);
		board[18] = new SentryGunPiece(18);
		board[20] = new CoinPiece(20);
	}
	
	/**
	 * Instantiates level 2
	 */
	private void level2() {
		/*
		 * Level start state
		 * |P|^| | |c| |Y| | | | |M| | | |o| | |T| |A|
		 * 
		 */
		playerStartLoc = 0;
		board[1] = new SpikesPiece(1);
		board[4] = new MovingCoinPiece(4);
		board[6] = new CoinThrowerPiece(6);
		board[11] = new MonsterPiece(11);
		board[15] = new CoinPiece(15);
		board[18] = new SentryGunPiece(18);
		board[20] = new AdvancePiece(20);
	}
	
	public Drawable[] getBoard() {
		return board;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return playerStartLoc;
	}
	
	
	
	
}
