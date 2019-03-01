/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This is the abstract class that houses several abstract methods, and two
 * concrete methods as well as a toString().
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 28, 2019
 */
public abstract class AbstractShape implements Shape {

	/**
	 * This field holds the name of each object.
	 */
	private String myName;

	/**
	 * This is the parameterized constructor that sets the name field to the name
	 * passed concatenated with the number passed.
	 */
	public AbstractShape(String theName, int theNumber) {
		myName = theName + theNumber;
	}

	/**
	 * This abstract method shall calculate the area of a given shape.
	 * 
	 * @return
	 */
	public abstract double calculateArea();

	/**
	 * This method shall get the name of the shape.
	 * 
	 * @return
	 */
	public String getName() {
		return myName;
	}

	/**
	 * This is the compareTo method.
	 * 
	 * @return : This method returns an integer representing the nature of the
	 *         comparison.
	 */
	@Override
	public int compareTo(Shape theOther) {
		int result = 0;
		double currentArea = calculateArea();
		double otherArea = theOther.calculateArea();
		if (currentArea < otherArea) {
			result = -1;
		} else if (otherArea > currentArea) {
			result = 1;
		}
		return result;
	}

	/**
	 * This is the equals method that comes with the Comparable interface.
	 * 
	 * @return : This method returns the nature of the equality.
	 */
	@Override
	public boolean equals(Object theOther) {
		boolean result = false;
		// Checking for equality of self
		if (this == theOther) {
			result = true;
		}
		// Checking for null
		if (theOther == null) {
			result = false;
		}
		// Checking for equality amongst instances
		if ((theOther instanceof Shape) == false) {
			// The type cast to Book
			Shape shape = (Shape) theOther;
		}
		return result;
	}

	/**
	 * This is the toString method.
	 * 
	 * @return : This returns a string representation of the object.
	 */
	@Override
	public String toString() {
		return "AbstractShape [myName=" + myName + "]";
	}
}
