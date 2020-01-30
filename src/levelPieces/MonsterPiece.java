package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MonsterPiece extends GamePiece implements Moveable {
	
	private static final char SYMBOL = 'M';
	private boolean moveThisTurn = true;

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
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		gameBoard[this.getLocation()] = null;
		
		if ( this.getLocation() > playerLocation) {
			// monster is on the right of the player
			for (int i = 1; i <= 2; i++  ) {
				if (gameBoard[this.getLocation() + i] == null) {
					this.setLocation(getLocation() + i);
				}
			}
		} else if ( this.getLocation() < playerLocation ) {
			for (int i = 1; i <= 2; i++ ) {
				if (gameBoard[this.getLocation() - i] == null) {
					this.setLocation(getLocation() - i);
				}
			}
		}
		
		gameBoard[this.getLocation()] = this;
		

	}

}
