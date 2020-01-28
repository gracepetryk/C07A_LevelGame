package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SentryGunPiece extends GamePiece {
	
	private static final char SYMBOL = 'T';

	public SentryGunPiece( int location) {
		super(SYMBOL, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) == 1) {
			return InteractionResult.HIT;
		} else if (playerLocation == this.getLocation()) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}

}
