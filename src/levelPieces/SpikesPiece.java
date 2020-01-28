package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpikesPiece extends GamePiece {
	
	private static final char SYMBOL = '^';

	public SpikesPiece(int location) {
		super(SYMBOL, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
		
	}

}
