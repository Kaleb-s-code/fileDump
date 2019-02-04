/*
 * This is a multiline comment
 */
package myPackage;

/**
 * This is the Critter interface that holds
 * 5 Constants and two abstract methods.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/4/2019
 */
public interface Critter {
//	5 Int constants
	public static final int NORTH = 0; 
	public static final int WEST = 1; 
	public static final int SOUTH = 2; 
	public static final int EAST = 3; 
	public static final int CENTER = 4;
//	Abstract methods
	public char getChar();
	public int getMove(CritterInfo theInfo);
	
}
