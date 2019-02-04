/**
 * This is a multiline comment
 */
package myPackage;

/**
 * This class represents the stone in the 
 * Program. 
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Stone extends AbstractCritter {

	/**
	 * This is the constructor that passes a char 
	 * To the super constructor.
	 */
	public Stone() {
		super('S');
	}

	/**
	 * This is the overridden abstract method 
	 * From the interface.
	 * 
	 * @return
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		return CENTER;
	}

}
