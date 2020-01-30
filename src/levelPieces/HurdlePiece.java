package levelPieces;

import gameEngine.Drawable;

public class HurdlePiece implements Drawable{

	public static final char SYMBOL = 'H';
	
	public HurdlePiece() {
		super();
	}

	@Override
	public void draw() {
		System.out.print(SYMBOL);
	}
	
}
