/**
 * multiline comment
 */
package myPackage;
import java.util.Random;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 *
 */
public class Turtle extends AbstractCritter {
//	Fields
	private int myCounter;
	private int myRandom;
	/**
	 * The constructor!
	 */
	public Turtle() {
		super('T');
		myRandom = new Random().nextInt();
		myCounter = new Random().nextInt(3);
	}

	/**
	 * This is the overridden method
	 * @return : 
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		int returnValue = CENTER;
		boolean randomBoolean = new Random().nextBoolean();

//		This is (group 1) that returns a movement based on
//		a number in range 11
		if (myCounter % 3 == 0) {
			if (randomBoolean == false) {
				int moveWhere = new Random().nextInt(11);
				if (moveWhere <= 1) {
					returnValue = NORTH;
				} else if (moveWhere <= 3 && moveWhere >= 2) {
					returnValue = EAST;
				} else if (moveWhere == 4) {
					returnValue = SOUTH;
				} else if (moveWhere >= 5 && moveWhere <= 7) {
					returnValue = WEST;
				} else {
					returnValue = CENTER;
				}
			}
//			This is (group 2) that returns a movement based on a 
//			Number in range 13
			else if (randomBoolean == true && myRandom <= 7) {
				int moveWhere = new Random().nextInt(13);
				if (moveWhere <= 3) {
					returnValue = SOUTH;
				} else if (moveWhere <= 5 && moveWhere <= 4) {
					returnValue = WEST;
				} else if (moveWhere <= 7 && moveWhere >= 6) {
					returnValue = NORTH;
				} else if (moveWhere >= 8) {
					returnValue = EAST;
				}
			}
		}
		myCounter += 1;	
		return returnValue;
	}
	
}
