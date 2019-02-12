/*
 * Multiline comment at the top of the file
 */
package myPackage;
import java.util.Random;

/**
 * This class represents the turtle in the program
 * That moves at 1/3 the speed of every other animal
 * In the simulation.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 *
 */
public class Turtle extends AbstractCritter {
	
	/**
	 * This field is a simple counter
	 */
	private int myCounter;
	
	/**
	 * This field holds a random integer that is created 
	 * When the class is instantiated.
	 */
	private int myRandom;
	
	/**
	 * This is the constructor for the turtle class that uses
	 * A set of random integers to accomplish the slow and 
	 * unpredictable behavior of the turtle.
	 */
	public Turtle() {
		super('T');
		myRandom = new Random().nextInt();
		myCounter = new Random().nextInt(3);
	}

	/**
	 * This is the overridden method
	 * @param theInfo : 
	 * @return : This method returns the next move of the 
	 * Turtle.
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		int result = CENTER;
		boolean randomBoolean = new Random().nextBoolean();

//		This is (group 1) that returns a movement based on
//		a number in range 11
		if (myCounter % 3 == 0) {
			if (randomBoolean == false) {
				int moveWhere = new Random().nextInt(11);
				if (moveWhere <= 1) {
					result = NORTH;
				} else if (moveWhere <= 3 && moveWhere >= 2) {
					result = EAST;
				} else if (moveWhere == 4) {
					result = SOUTH;
				} else if (moveWhere >= 5 && moveWhere <= 7) {
					result = WEST;
				} else {
					result = CENTER;
				}
			}
//			This is (group 2) that returns a movement based on a 
//			Number in range 13 omitting CENTER
		else if (randomBoolean == true && myRandom <= 7) {
			int moveWhere = new Random().nextInt(13);
			if (moveWhere <= 3) {
				result = SOUTH;
			} else if (moveWhere <= 5 && moveWhere <= 4) {
				result = WEST;
			} else if (moveWhere <= 7 && moveWhere >= 6) {
				result = NORTH;
			} else if (moveWhere >= 8) {
				result = EAST;
				}
			}
		}
		myCounter += 1;	
		return result;
	}
}
