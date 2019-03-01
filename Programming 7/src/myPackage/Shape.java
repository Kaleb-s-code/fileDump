/*
 * Multiline comment at the top of the document
 */
package myPackage;

/**
 * This class is an interface that extends from Comparable and passes the
 * responsibility of implementation on to the sub classes which implement this
 * interface.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 28, 2019
 */
public interface Shape extends Comparable<Shape> {
	/**
	 * This abstract method shall calculate the area of a given shape.
	 * 
	 * @return
	 */
	public double calculateArea();

	/**
	 * This method shall make a copy of the shape for further processing.
	 * 
	 * @return
	 */
	public Shape copyShape();

	/**
	 * This method shall get the name of the shape.
	 * 
	 * @return
	 */
	public String getName();
}
