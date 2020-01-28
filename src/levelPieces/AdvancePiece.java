package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class AdvancePiece extends GamePiece {

	private static final char SYMBOL = 'A';
	
	public AdvancePiece( int location) {
		super(SYMBOL, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.ADVANCE;
		} else {
			return InteractionResult.NONE;
		}
	}

}
