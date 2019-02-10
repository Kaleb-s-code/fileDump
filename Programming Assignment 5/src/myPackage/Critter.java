/*
 * Multiline comment at the top of the file
 */
//package myPackage;

/**
 * This is the Critter interface that holds
 * 5 Constants and two abstract methods.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public interface Critter {
	/**
	 * This constant represents a direction of North.
	 */
	public static final int NORTH = 0; 
	/**
	 * This constant represents a direction of West.
	 */
	public static final int WEST = 1; 
	/**
	 * This constant represents a direction of South.
	 */
	public static final int SOUTH = 2; 
/**
 * This constant represents a direction of East.
 */
	public static final int EAST = 3; 
	/**
	 * This constant represents a non direction
	 * Where the critter will stay still.
	 */
	public static final int CENTER = 4;
	/**
	 * This is an abstract method to be included in 
	 * Whatever implements this interface.
	 * 
	 * @return : This is an abstract method that 
	 * returns nothing
	 */
	public char getChar();
	/**
	 * This is an abstract method to be included in 
	 * Whatever implements this interface.
	 * 
	 * @param theInfo : 
	 * @return : This method returns nothing as it
	 * Is an abstract method. 
	 */
	public int getMove(CritterInfo theInfo);
	
}
