/*
 * Multiline comment at the top of the file
 */
package myPackage;

/**
 * This class represents the Wolf which behaves 
 * As a pack, moving together throughout the
 * Grid world.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Wolf extends AbstractCritter {
	/**
	 * This fields represents the direction the wolf will go.
	 */
	private int myDirection;
	/**
	 * This field represents a counter that I use 
	 * In the getMove() method.
	 */
	private int myCount;
	/**
	 * This field is used to determine if a move is the 
	 * Initial move or not.
	 */
	private boolean myFirst;
	/**
	 * This field represents the target value 
	 */
	private int myTarget;
	
	/**
	 * This is the constructor for the wolf class that 
	 * Uses basic fields for the direction of the wolf, and 
	 * a couple counters, as well as a boolean.
	 */
	public Wolf() {
		super('W');
		myDirection = EAST;
		myCount = 0;
		myFirst = true;
		myTarget = 1;
		
	}

	/**
	 * This is the overridden method from the interface
	 * That handles the moves of the wolves.
	 * 
	 * @param theInfo : 
	 * @return : This method returns a direction based 
	 * On conditions.
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		myCount += 1;
		
		if (myCount == myTarget) {
			myCount = 0;
			if (myFirst == false) {
				myTarget += 1;
				myFirst = true;
				if (myDirection == EAST) {
					myDirection = NORTH;
				} else if (myDirection == NORTH) {
					myDirection = WEST;
				} else if (myDirection == WEST) {
					myDirection = SOUTH;
				} else if (myDirection == SOUTH) {
					myDirection = EAST;
				}
			}
			if (myFirst == true) {
				myFirst = false;
			}
		}
		int direction = myDirection;
		return direction;
	}
}
