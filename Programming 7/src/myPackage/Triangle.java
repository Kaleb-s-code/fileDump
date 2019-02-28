/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class is a representation of a Triangle object that inherits
 * from the parent abstract class AbstractShape.
 * 
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 23, 2019
 */
public class Triangle extends AbstractShape {

	/**
	 * This is the side one side.
	 */
	private double mySideA;

	/**
	 * This is another side.
	 */
	private double mySideB;

	/**
	 * This is another side.
	 */
	private double mySideC;

	/**
	 * This is the ID field.
	 */
	private static int myID;

	/**
	 * This is the non - parameterized constructor.
	 */
	public Triangle() {
		this(1.0, 1.0, 1.0);
	}

	/**
	 * This is the parameterized constructor that decides what is a side,
	 * and which of the parameters is the hypotenuse. It then determines
	 * if the values are valid and throws an exception if that is the
	 * case.
	 * 
	 * @param theName
	 * @param theNumber
	 */
	public Triangle(final double theSideA, final double theSideB, final double theSideC) {
		super("Triangle", myID++);
		double hypot = 1.0;
		double sideOne = 1.0;
		double sideTwo = 1.0;
//System.out.println("\n****Sides coming in: " + theSideA + ", " + theSideB + ", " + theSideC);
		if (theSideA > theSideB && theSideA > theSideC) {
			hypot = theSideA;
			sideOne = theSideB;
			sideTwo = theSideC;

		} else if (theSideB > theSideA && theSideB > theSideC) {
			hypot = theSideB;
			sideOne = theSideA;
			sideTwo = theSideC;

		} else if (theSideC > theSideA && theSideC > theSideB) {
			hypot = theSideC;
			sideOne = theSideB;
			sideTwo = theSideA;
		}

		else {
			sideOne = theSideA;
			sideTwo = theSideB;
			hypot = theSideC;
		}
		mySideA = sideOne;
		mySideB = sideTwo;
		mySideC = hypot;

		if (theSideA <= 0.0 || theSideB <= 0.0 || theSideC <= 0.0 || sideOne + sideTwo == hypot) {
			myID--;
			throw new IllegalArgumentException("ERROR! Negative or 0 Value can't "
					+ "be applied to a Triangle side. The sum of the sides must also not" + " equal the length of the hypotenuse.");
		} else if (calculateArea() <= 0) {
			myID--;
			throw new IllegalArgumentException("ERROR! Not a triangle");
		}

	}

	/**
	 * This is a setter for the field.
	 * 
	 * @param theSideA : this is the side passed.
	 */
	public void setMySideA(double theSideA) {
		mySideA = theSideA;
	}

	/**
	 * This is a setter for the field.
	 * 
	 * @param theSideB : this is the side passed.
	 */
	public void setMySideB(double theSideB) {
		mySideB = theSideB;
	}

	/**
	 * This is a setter for the field.
	 * 
	 * @param theSideC : this is the side passed.
	 */
	public void setMySideC(double theSideC) {
		mySideC = theSideC;
	}

	/* 
	 * 
	 */
	@Override
	public Shape copyShape() {
		
		return null;
	}

	/*
	 * This method calculates the area of the triangle based on Heron's
	 * formula which uses the three sides, neglecting the need for a base
	 * and height.
	 */
	@Override
	public double calculateArea() {
		double result = 0;
		double s = (mySideA + mySideB + mySideC) / 2;
		Double area = Math.sqrt((s * (s - mySideA)) * (s - mySideB) * (s - mySideC));
		if (!area.isNaN()) {
			result = (double) Math.round(area * 100.0) / 100.0;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Triangle" + myID + " [SideA: " + mySideA + ", SideB: " + mySideB + ", SideC: " + mySideC + "] Area: " + calculateArea();
	}


}
