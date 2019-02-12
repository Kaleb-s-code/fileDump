/*
 * Multiline comment at the top of the file
 */
package myPackage;

import java.util.Random;

/**
 * This class is the representation of a mouse bound by a random
 * Zig-zag pattern. Every mouse begins moving based on a random
 * Direction, then they move another direction that is 
 * Controlled by getNewDirection().
 * 
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
	 * Constructor for the mouse class that uses
	 * A random non center direction, and a counter
	 * to accomplish the unique mouse behavior.
	 */
	public Mouse() {
		super('M');
		myDirection = new Random().nextInt(CENTER);
		myGetMoveCounter = 0;
	}
	
	/**
	 * This method handles the directions that 
	 * The mouse is to travel. They either go
	 * The random direction generated during instantiation
	 * Or they go where ever getNewDirection() sends them.
	 * This method in combination with getNewDirection()
	 * Accomplishes the random zig-zag pattern.
	 * 
	 * @param theInfo : 
	 * @return : This method returns the direction
	 * a mouse is to move when called.
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		int result = 0;
		myGetMoveCounter += 1;
		if (myGetMoveCounter % 3 > 0) {
			result = myDirection;
		}	else if (myGetMoveCounter % 3 == 0) {
					result = getNewDirection(myDirection);
		}
		return result;
	}

	/**
	 * This method uses a series of if conditions and
	 * a random boolean to determine where on the grid 
	 * a mouse can and should move.
	 * 
	 * @return : This method returns the new direction
	 * That the mouse should travel.
	 * @param theDirection : This parameter is 
	 * a direction passed from getMove() which will
	 * Be converted into another direction based on
	 * The allowable directions  
	 */
	public int getNewDirection(int theDirection) {
		int result = theDirection;
		boolean randomBool = new Random().nextBoolean();
//		Handling NORTH
		if (theDirection == NORTH && randomBool == true) {
			result = WEST;
		} else if (theDirection == NORTH && randomBool == false) {
			result = EAST;
//			Handling WEST
		} else if (theDirection == WEST && randomBool == true) {
			result = NORTH;
		} else if (theDirection == WEST && randomBool == false) {
			result = SOUTH;
//			Handling SOUTH
		} else if (theDirection == SOUTH && randomBool == true) {
			result = EAST;
		} else if (theDirection == SOUTH && randomBool == false) {
			result = WEST;
//			Handling EAST
		} else if (theDirection == EAST && randomBool == true) {
			result = SOUTH;
		} else if (theDirection == EAST && randomBool == false) {
			result = NORTH;
		}
		return result;
	}
}
