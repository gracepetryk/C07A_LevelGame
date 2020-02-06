/**
 * @author Grant Falkner
 * @author Grace Petryk
 */

package levelPieces;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class TestInteractions {
	

	/**
	 * if player lands on piece, advance
	 */
	@Test
	public void testAdvancePiece() {
		AdvancePiece piece = new AdvancePiece(6);
		testLandOnInteraction(InteractionResult.ADVANCE, piece, 6);
	}
	
	/**
	 * if player lands on piece, get a point
	 */
	@Test
	public void testCoinPiece() {
		CoinPiece piece = new CoinPiece(6);
		testLandOnInteraction(InteractionResult.GET_POINT, piece, 6);
	}
	
	/**
	 * if player lands on piece, hit player
	 */
	@Test
	public void testMonsterPiece() {
		MonsterPiece piece = new MonsterPiece(6);
		testLandOnInteraction(InteractionResult.HIT, piece, 6);
	}
	
	
	/**
	 * if player lands on piece, get a point
	 */
	@Test
	public void testMovingCoinPiece() {
		MovingCoinPiece piece = new MovingCoinPiece(6);
		testLandOnInteraction(InteractionResult.GET_POINT, piece, 6);
	}
	
	
	/**
	 * if player lands on piece, kill player
	 */
	@Test
	public void testSpikesPiece() {
		SpikesPiece piece = new SpikesPiece(6);
		testLandOnInteraction(InteractionResult.KILL, piece, 6);
	}
	
	/**
	 * if player is directly next to piece, hit player
	 * if player lands on piece, get point
	 */
	@Test
	public void testSentryGunPiece() {
		SentryGunPiece piece = new SentryGunPiece(6);
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[6] = piece;
		
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 5 || i == 7) {
				assertEquals(InteractionResult.HIT, piece.interact(gameBoard, i));
			} else if (i == 6) {
				assertEquals(InteractionResult.GET_POINT, piece.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, piece.interact(gameBoard, i));
			}
		}
	}
	
	/**
	 * if player is 2 squares from the piece, give a point
	 * if player lands on piece, hit player
	 */
	@Test
	public void testCoinThrowerPiece() {
		CoinThrowerPiece piece = new CoinThrowerPiece(6);
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[6] = piece;
		
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 4 || i == 8) {
				assertEquals(InteractionResult.GET_POINT, piece.interact(gameBoard, i));
			} else if (i == 6) {
				assertEquals(InteractionResult.HIT, piece.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, piece.interact(gameBoard, i));
			}
		}
	}
	

	/**
	 * This function is for testing pieces that only interact when a player is directly on them
	 */
	private void testLandOnInteraction(InteractionResult desiredInteractionResult , GamePiece piece, int location) {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[location] = piece;
		
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == location) {
				assertEquals(desiredInteractionResult, piece.interact(gameBoard, location));
			} else {
				assertEquals(InteractionResult.NONE, piece.interact(gameBoard, i));
			}
		}
	}
}
