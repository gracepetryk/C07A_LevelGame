package levelPieces;

import static org.junit.Assert.fail;

import org.junit.Test;

import gameEngine.GameEngine;
import gameEngine.Drawable;

public class TestMovingPieces {
	
	/**
	 * Tests to ensure moving coin moves properly
	 * - Ensures that coin stays on board
	 * - Ensures that coin does not move on top of other pieces
	 * - Ensures movement is at least somewhat random
	 */
	@Test
	public void testMovingCoinPiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// place a hurdle on spots 10 and 5 to ensure coin never moves past them
		HurdlePiece hurdlePiece1 = new HurdlePiece(); 
		HurdlePiece hurdlePiece2 = new HurdlePiece(); 
		gameBoard[5] = hurdlePiece1;
		gameBoard[10] = hurdlePiece2;
		
		MovingCoinPiece movingCoinPiece = new MovingCoinPiece(7);
		gameBoard[7] = movingCoinPiece;
		
		for (int i = 0; i < 100; i++) {
			movingCoinPiece.move(gameBoard, 12); // player location is 12, not important for this test
			int location = movingCoinPiece.getLocation();
			
			if (location <= 5 || location >= 10) {
				fail("Moving coin attempted to move past another piece");
			}
		}
		
		// test to see if coin stays on board and has random movement
		
		// reset board
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingCoinPiece = new MovingCoinPiece(10);
		gameBoard[10] = movingCoinPiece;
		
		// holds whether each spot has been moved too
		boolean[] hasMovedToSpotArray = new boolean[GameEngine.BOARD_SIZE];
		
		for (int i = 0; i < 2000; i++) {
			movingCoinPiece.move(gameBoard, 6);
			int location = movingCoinPiece.getLocation();
			
			hasMovedToSpotArray[location] = true;
			
			if (location < 0 || location >= GameEngine.BOARD_SIZE) {
				fail("moving coin attempted to move outside board");
			}
		}
		
		for (int i = 0; i < hasMovedToSpotArray.length; i++) {
			if (hasMovedToSpotArray[i] == false) {
				fail("coin never moved to location: " + i);
			}
		}
	}
}
