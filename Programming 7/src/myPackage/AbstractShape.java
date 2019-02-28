/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 23, 2019
 */
public abstract class AbstractShape implements Shape {

	/**
	 * This field holds the name of each object.
	 */
	private String myName;

	/**
	 * This is the parameterized constructor that sets the name field to
	 * the name passed concatenated with the number passed.
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
	 * This method shall make a copy of the shape for further processing.
	 * 
	 * @return
	 */
	// public Shape copyShape() {
	// //TODO
	// }

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
	 */
	@Override
	public int compareTo(Shape theOther) {
		int result = 0;
		int titles = getName().compareTo(theOther.getName());
		// boolean authors = getAuthors().equals(theOther.getAuthors());
		equals(theOther);
		if (titles < 0) {
			result = -1;
		} else if (titles > 0) {
			result = 1;
		}
		// } else if (titles == 0) {
		// if (authors) {
		// result = 0;
		// } else if (!authors) {
		// result = -1;
		// }
		// }
		return result;
	}

	/*
	 * This is the equals method that goes along with the compareTo.
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
			// result = (shape.myName == myBookTitle && book.myAuthorsNames ==
			// myAuthorsNames);
		}
		return result;
	}
	
	/* 
	 * 
	 */
	@Override
	public String toString() {
		return "AbstractShape [myName=" + myName + "]";
	}
}
