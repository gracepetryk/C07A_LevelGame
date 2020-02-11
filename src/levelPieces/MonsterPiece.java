package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Player;

public class MonsterPiece extends GamePiece implements Moveable {
	
	private static final char SYMBOL = 'M';

	public MonsterPiece( int location) {
		super(SYMBOL, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	/**
	 * moves the monster towards the player. It checks the space next to the monster and
	 * one over to see if it's free or occupied by the player, and if it is it moves to that space.
	 * moves to the near space before moving to the far one.
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		gameBoard[this.getLocation()] = null;
		
		// test the squares +/- 2 from the monster and move towards them, jumping over obstacles.
		
		int playerDirection = 1; // if 1, player is to right
		
		if (playerLocation < this.getLocation()) {
			playerDirection =  -1; /// if -1, player is to left
		}
		
		// check the two spots in the direction of the player and move if free
		for (int i = 1; i <= 2; i++) {
			int targetIndex = this.getLocation() + (i * playerDirection);
			if (gameBoard[targetIndex] == null) {
				this.setLocation(targetIndex);
				break; // break so we don't move 2 spaces if only one is needed
			}
		}
		
		gameBoard[this.getLocation()] = this;
	}

}
