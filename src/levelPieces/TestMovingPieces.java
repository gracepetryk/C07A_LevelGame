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
			// move the coin 2000 times and check to make sure each spot has been moved too one
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
	
	
	/**
	 * Tests the movement of the monster piece
	 * - 1. Ensures it moves towards player
	 * - 2. Ensures it jumps over piece
	 * - 3. Ensures it doesn't jump over an empty piece
	 * - 4. Ensures it doesn't jump over two pieces
	 */
	@Test
	public void testMonsterPiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		MonsterPiece monsterPiece = new MonsterPiece(10);
		gameBoard[10] = monsterPiece;
		
		// test 1 and 3
		monsterPiece.move(gameBoard, 0);
		
		if (monsterPiece.getLocation() != 9) {
			fail("monster piece did not move only one space towards player");
		}
		
		// test 2
		HurdlePiece hurdlePiece = new HurdlePiece();
		gameBoard[8] = hurdlePiece;
		
		monsterPiece.move(gameBoard, 0);
		
		if (monsterPiece.getLocation() != 7) {
			fail("monster piece did not jump over piece towards player");
		}
		
		// test 4
		
		gameBoard[6] = hurdlePiece;
		gameBoard[5] = hurdlePiece;
		
		monsterPiece.move(gameBoard, 0);
		
		if (monsterPiece.getLocation() != 7) {
			fail("monster piece attempted to jump over more than one piece");
		}
	}
}
