package gameEngine;

import java.util.ArrayList;

import levelPieces.GamePiece;

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
		if (levelNum == 1) {
			level1();
		}
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
	
	
	/*
	 * instantiates level 1
	 */
	private void level1() {
		
	}
	
}
