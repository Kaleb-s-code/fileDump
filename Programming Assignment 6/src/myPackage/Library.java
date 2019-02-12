/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;

/**
 * This class does things and stuff that a class should do And there
 * are more things that it can do too.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/14/2019
 */
public class Library {

	/**
	 * This field holds all of the book objects in the library
	 */
	private ArrayList<Book> myBookObjects;

	/**
	 * This is the constructor that should create an empty ArrayList of
	 * books.
	 */
	public Library() {
		// TODO
	}

	/**
	 * This method should add the book to the end of the ArrayList if the
	 * book argument is validated. Else, it will throw an exception.
	 * 
	 * @param theBook : This is the book passed to the method.
	 * @return : This method returns whether or not the book was
	 *         successfully added to the ArrayList.
	 */
	public boolean add(final Book theBook) {
		boolean result = false;
		if (theBook == null) {
			throw new IllegalArgumentException();
		} else {
			result = true;
			myBookObjects.add(theBook);
		}
		return result;
	}

	/**
	 * This method is supposed to return an ArrayList where every title
	 * in the library that matches the parameter exactly, is added to the
	 * Array.
	 * 
	 * @param theTitle : This is the title that will be compared
	 * to the titles in the library.
	 * @return : This method returns an ArrayList of the matching
	 * titles.
	 */
	public ArrayList<Book> findTitles(final String theTitle) {
		return myBookObjects;
		/*
		 * This method is supposed to return an ArrayList where 
		 * every title in the library that matches the parameter 
		 * exactly, is added to the Array.
		 */
		// TODO
	}

	/**
	 * This method sorts the library's book in ascending order according to 
	 * the title field
	 */
	public void sort() {
	//TODO
	}

	/**
	 * This method is supposed to return a properly formatted 
	 * string representation of all the books in the library.
	 * Title followed by authors. 
	 * 
	 * @return : This method returns a string of sorts
	 */
	@Override
	public String toString() {
		return "Library [myBookObjects=" + myBookObjects + "]";
	}

}













