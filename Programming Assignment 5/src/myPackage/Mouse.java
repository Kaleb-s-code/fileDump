/**
 * Multiline comment
 */
package myPackage;

import java.util.Random;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Mouse extends AbstractCritter {
	/**
	 * This field represents the direction that the mouse
	 * Starts off heading.
	 */
	private int myDirection;
	/**
	 * This field is a counter that is used to keep track
	 * Track of the times getMove() is called 
	 */
	private int myGetMoveCounter = 0;
	/**
	 * This field is the total counter used in getNewDirection()
	 * For finding a new zig-zag pattern the mouse should 
	 * Head.
	 */
	private int myTotalCounter = 0;
	
	/**
	 * Constructor
	 */
	public Mouse() {
		super('M');
		myDirection = NORTH;
	}
	
	/**
	 * Another method 
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		int result = myDirection;
//	Trying to get the Mouse to hold a position for 2 iterations 
		myGetMoveCounter += 1;
		if (myGetMoveCounter > 1) {
			result = getNewDirection();
//		Reset counter
		}
		
		myTotalCounter += 1;
		return result;
	}
	
	/**
	 * Playing with an idea
	 * @return
	 */
	public int getNewDirection() {
		int result = myDirection;
		
		if (myTotalCounter % 4 == 0) {
			myTotalCounter = 0;
			myGetMoveCounter = 0;
			myDirection = new Random().nextInt(CENTER);
			result = myDirection;
		}
		
		return result;
	}

}
