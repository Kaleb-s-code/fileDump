/**
 * multiline comment
 */
package myPackage;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public class Wolf extends AbstractCritter {
//	Fields
	private int myDirection;
	private int myCount;
	private boolean myFirst;
	private int myTarget;
	
	
	/**
	 * This is the constructor 
	 */
	public Wolf() {
		super('W');
		
	}

	/**
	 * This is the overridden method from the interface
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		return 0;
	}

}
