/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class represents a circle.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 23, 2019
 */
public class Circle extends AbstractShape {

	/**
	 * This is the radius field.
	 */
	private double myRadius;

	/**
	 * This is the ID field.
	 */
	private static int myID = 0;

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
		super("Circle", myID++);
		if (theRadius <= 0.0) {
			myID--;
			throw new IllegalArgumentException("ERROR! Negative or 0\nValue can't" + "be applied to a circle radius.");
		}
		myRadius = theRadius;
	}

	/*
	 *  
	 */
	@Override
	public Shape copyShape() {
		Circle circle = new Circle(myRadius);
		return circle;
	}

	/*
	 *
	 */
	@Override
	public double calculateArea() {
		return Math.round(((Math.PI) * (myRadius * myRadius)) * 100.0) / 100.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle" + myID + " [myRadius: " + myRadius + "] Area: " + calculateArea();
	}

}
