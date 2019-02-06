/**
 * multiline comment
 */
package myPackage;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Frog extends AbstractCritter{

	private int myDirection;
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
