/*
 * Multiline comment at the top of the file
 */
//package myPackage;

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
	 * @param theInfo : 
	 * @return : This method returns a direction
	 * Of Center.
	 */
	@Override
	public int getMove(CritterInfo theInfo) {
		return CENTER;
	}
}
