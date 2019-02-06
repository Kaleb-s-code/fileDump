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
//Fields
	private int myDirection;
	private int myGetMoveCounter = 0;
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
		int returnValue = myDirection;
//	Trying to get the Mouse to hold a position for 2 iterations 
		myGetMoveCounter += 1;
		if (myGetMoveCounter > 1) {
			returnValue = getNewDirection();
//		Reset counter
		}
		
		myTotalCounter += 1;
		return returnValue;
	}
	
	/**
	 * Playing with an idea
	 * @return
	 */
	public int getNewDirection() {
		int returnValue = myDirection;
		
		if (myTotalCounter % 4 == 0) {
			myTotalCounter = 0;
			myGetMoveCounter = 0;
			myDirection = new Random().nextInt(CENTER);
			returnValue = myDirection;
		}
		
		
		return returnValue;
	}

}
