package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MovingCoinPiece extends GamePiece implements Moveable {

	private static final char SYMBOL = 'c';
	
	public MovingCoinPiece(int location) {
		super(SYMBOL, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	/**
	 *	This method will move the piece to the left or right depending on
	 *	if that space is occupied. If both are unoccupied, it decides at
	 *	random.  
	 * 
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		gameBoard[this.getLocation()] = null;
		
		boolean leftFree = false;
		boolean rightFree = false;
		
		// free on left side
		int leftIndex = this.getLocation() - 1;
		leftFree = leftIndex >= 0 && gameBoard[leftIndex] == null;
		
		
		// free on right side
		int rightIndex = this.getLocation() + 1;
		rightFree = rightIndex < GameEngine.BOARD_SIZE && gameBoard[rightIndex] == null;
		
		// randomly move left or right
		if (leftFree && rightFree) {
			if ( Math.random() < 0.5) {
				this.setLocation(this.getLocation() - 1);
			} else {
				this.setLocation(this.getLocation() + 1);
			}
		} else if (leftFree) {
			this.setLocation(this.getLocation() - 1);
		} else if (rightFree) {
			this.setLocation(this.getLocation() + 1);
		}
		gameBoard[this.getLocation()] = this;
		

	}

}
