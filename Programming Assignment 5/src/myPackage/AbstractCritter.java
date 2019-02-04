/*
 * This is a multiline comment
 */
package myPackage;

/**
 * This abstract class implements the Critter interface
 * And sets the instance variable indicating the type of 
 * Critter, to the parameter passed parameter in the 
 * Constructor. 
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2018
 */
public abstract class AbstractCritter implements Critter {

	//	Field
	private char myCritter;
	
	/**
	 * Overridden method from interface
	 */
	@Override
	public char getChar() {
		return myCritter;
	}
	//	Constructor
	
	/**
	 * Constructor that sets the field to the parameter passed
	 * 
	 * @param theChar : This is the critter identifier
	 */
	public AbstractCritter(final char theChar) {
		myCritter = theChar;
	}
}
