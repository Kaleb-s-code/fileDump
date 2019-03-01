/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class represents a circle.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 28, 2019
 */
public class Circle extends AbstractShape {

	/**
	 * This is the radius field.
	 */
	private double myRadius;

	/**
	 * This is the ID field.
	 */
	private static int myID;

	/**
	 * This is the non - parameterized constructor.
	 */
	public Circle() {
		this(1.0);
	}

	/**
	 * This is the parameterized constructor which throws an
	 * IllegalArgumnetException if the value is less than or equal to 0.
	 * 
	 * @param theRadius
	 */
	public Circle(final double theRadius) {
		super("Circle", ++myID);
		if (theRadius <= 0.0) {
			myID--;
			throw new IllegalArgumentException(
					"ERROR! Negative or 0 Value can't" + "be applied to a circle radius.");
		}
		myRadius = theRadius;
	}

	/**
	 * This method allows a circle to be copied.
	 * 
	 * @return : This is the new circle object based on the current circle's radius.
	 */
	@Override
	public Shape copyShape() {
		Circle circle = new Circle(myRadius);
		return circle;
	}

	/**
	 * This is a setter for the radius.
	 * 
	 * @param theRadius : This is the radius passed.
	 */
	public void setMyRadius(double theRadius) {
		myRadius = theRadius;
	}

	/**
	 * This method calculates the area of the shape and attempts to correct the
	 * excessive trailing digits.
	 * 
	 * @return : This returns a double representing the area.
	 */
	@Override
	public double calculateArea() {
		return Math.round(((Math.PI) * (myRadius * myRadius)) * 100.0) / 100.0;
	}

	/**
	 * This is the toString()
	 * 
	 * @return : This method returns a string representation of the object.
	 */
	@Override
	public String toString() {
		return getName() + " [myRadius: " + myRadius + "] Area: " + calculateArea();
	}
}
