/*
 * Multiline comment at the top of the file
 */
package myPackage;
import java.util.Random;
/**
 * This class represents the bat in the program
 * Which behaves randomly
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Bat extends AbstractCritter {

	/**
	 * This is the constructor which
	 * Calls the super constructor and 
	 * Passes it a char.
	 */
	public Bat() {
		super('B');
	}

	/**
	 * This is the overridden method from the 
	 * Interface which should return a random
	 * Direction up to, but not including CENTER.
	 * 
	 * @param theInfo : 
	 * @return : This method returns a random
	 * Position not including center.
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		return new Random().nextInt(CENTER);
	}

	
}
