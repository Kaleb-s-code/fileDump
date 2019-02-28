/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class does things and stuff that a class should do And there
 * are more things that it can do too.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 23, 2019
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
	 * This is the parameterized constructor that validates the dimensions
	 * passed. then either throws an exception if invalid, or sets the
	 * fields to the passed values.
	 * 
	 * @param theName
	 * @param theNumber
	 */
	public Rectangle(double theLength, double theWidth) {
		super("Rectangle", myID++);
//		System.out.println("This is the Length: " + theLength + "\n" + "This is the Width: " + theWidth);
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
	 * @param theLength
	 */
	public void setLength(final double theLength) {
		myLength = theLength;
	}

	/**
	 * This method is a setter for the width field.
	 * 
	 * @param theWidth
	 */
	public void setWidth(final double theWidth) {
		myWidth = theWidth;
	}

	/*
	 * This method makes a copy of the shape object.
	 */
	@Override
	public final Shape copyShape() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * This method simply calculates the area of the rectangle.
	 */
	@Override
	public double calculateArea() {
		return myLength * myWidth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle" + myID + " [Length: " + myLength + ", Width: " + myWidth + "] Area: " + calculateArea();
	}
}
