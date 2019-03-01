/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class represents a rectangle.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 28, 2019
 */
public class Rectangle extends AbstractShape {

	/**
	 * This is the length of the rectangle.
	 */
	private double myLength;

	/**
	 * This is the width of the rectangle.
	 */
	private double myWidth;

	/**
	 * This is the ID field.
	 */
	private static int myID;

	/**
	 * This is the non- parameterized constructor
	 */
	public Rectangle() {
		this(1.0, 1.0);
	}

	/**
	 * This is the parameterized constructor that validates the dimensions passed.
	 * then either throws an exception if invalid, or sets the fields to the passed
	 * values.
	 * 
	 * @param theLength : This is the length passed.
	 * @param theWidth  : This is the width passed.
	 */
	public Rectangle(double theLength, double theWidth) {
		super("Rectangle", ++myID);
		if (theLength <= 0.0 || theWidth <= 0.0) {
			myID--;
			throw new IllegalArgumentException(
					"ERROR! Negative or 0 Value can't " + "be applied to a rectangle length or width.");
		}
		myLength = theLength;
		myWidth = theWidth;
	}

	/**
	 * This method is a setter for the length field.
	 * 
	 * @param theLength : This is the length passed.
	 */
	public void setLength(final double theLength) {
		myLength = theLength;
	}

	/**
	 * This method is a setter for the width field.
	 * 
	 * @param theWidth : This is the width.
	 */
	public void setWidth(final double theWidth) {
		myWidth = theWidth;
	}

	/**
	 * This method allows for copying of rectangle object.
	 * 
	 * @return : This returns the new rectangle.
	 */
	@Override
	public final Shape copyShape() {
		Rectangle rectangle = new Rectangle(myLength, myWidth);
		return rectangle;
	}

	/**
	 * This method calculates the area of the shape and attempts to correct the
	 * excessive trailing digits.
	 * 
	 * @return : This returns a double representing the area.
	 */
	@Override
	public double calculateArea() {
		return myLength * myWidth;
	}

	/**
	 * This is the toString()
	 * 
	 * @return : This method returns a string representation of the object.
	 */
	@Override
	public String toString() {
		return getName() + " [Length: " + myLength + ", Width: " + myWidth + "] Area: " + calculateArea();
	}
}
