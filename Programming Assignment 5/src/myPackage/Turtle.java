/**
 * multiline comment
 */
package myPackage;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 *
 */
public class Turtle extends AbstractCritter {
	
	private int myDirection;
	private boolean myShouldMove;
	private int myCounter;
	
	/**
	 * The constructor!
	 */
	public Turtle() {
		super('T');
		myDirection = CENTER;
		myShouldMove = false;
		myCounter = 0;
	}

	/**
	 * This is the overridden method
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		int returnValue = 0;
		myCounter += 1;
		if (myCounter % 3 == 0) {
			myShouldMove = true;
			
		}
		return returnValue;
	}
	public int shouldMove() {
		return 0;
	}
}
