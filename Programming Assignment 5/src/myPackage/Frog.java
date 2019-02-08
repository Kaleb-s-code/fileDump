/**
 * multiline comment
 */
package myPackage;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Frog extends AbstractCritter{
	/**
	 * This field holds the direction that is initially 
	 * Set to CENTER during instantiation
	 */
	private int myDirection;
	/**
	 * This field is a simple counter
	 */
	private int myCount;
	
	/**
	 * Constructor 
	 */
	public Frog() {
		super('F');
		myDirection = CENTER;
		myCount = 0;
	}

	/**
	 * This is the overridden method
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		return CENTER;
	}

}
