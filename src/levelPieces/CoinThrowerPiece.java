package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class CoinThrowerPiece extends GamePiece {

	private static final char SYMBOL = 'Y';
	
	public CoinThrowerPiece( int location) {
		super(SYMBOL, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) == 2) {
			return InteractionResult.GET_POINT;
		} else if (playerLocation == this.getLocation()) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}

}
