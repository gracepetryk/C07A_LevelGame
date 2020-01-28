package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class CoinPiece extends GamePiece {
	
	private static final char SYMBOL = 'o';

	public CoinPiece(int location) {
		super(SYMBOL, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}

}
