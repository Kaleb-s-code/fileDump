/*
 * Multiline comment at the top of the file
 */
//package myPackage;
/**
 * This class represents the frog in the 
 * Program that never gets stuck on a stone.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Frog extends AbstractCritter {
	
	/**
	 * This field holds the direction that is initially 
	 * Set to CENTER during instantiation
	 */
	private int myDirection;
	
	/**
	 * This field is a simple counter
	 */
	private double myCount;
	
	/**
	 * This is the constructor for the Frog class. This 
	 * constructor consists of a char, and two ints serving 
	 * individual purposes.  
	 */
	public Frog() {
		super('F');
		myDirection = CENTER;
		myCount = 0;
	}

	/**
	 * This is the overridden method that determines
	 * The overall direction of the Frog.
	 * 
	 * @param theInfo : 
	 * @return : This method returns the direction
	 * That a turtle is supposed to go based on
	 * a random double. 
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		double randomNumber = Math.random();
		int result = CENTER;
		if (myCount == 0) {
			if (randomNumber < 0.25) {
				myDirection = NORTH;
			} else if (randomNumber  < 0.5) {
				myDirection = SOUTH;
			} else if (randomNumber < 0.75) {
				myDirection = EAST;
			} else {
				myDirection = WEST;
			}
		}
		myCount++;
		if (myCount == 3) {
			myCount = 0;
		}
		if(theInfo.getNeighbor(myDirection) == 'S') {
			result = CENTER;
		} else {
			result = myDirection;
		}
		return result;
	}
}
