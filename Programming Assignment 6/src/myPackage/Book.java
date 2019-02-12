/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;

/**
 * This class does things and stuff that a class should do 
 * And there are more things that it can do too.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/14/2019
 */
public class Book implements Comparable<Book> {
	
	/**
	 * Private field
	 */
	private String myBookTitle;
	
	/**
	 * Private field
	 */
	private ArrayList<String> myAuthorsNames;
	
	/**
	 * This is the constructor that does some things
	 * 
	 * @param theTitle : The title of the books
	 * @param theAuthors : The name of the author(s)
	 */
	public Book(final String theTitle, 
													final ArrayList<String> theAuthors) {
		if (theTitle == null || theAuthors == null) {
			throw new IllegalArgumentException();
		} else {
			ArrayList<String> myAuthorsNames = new ArrayList<String>();
			myBookTitle = theTitle;
			myAuthorsNames = theAuthors;
		}
	}

	/**
	 * Getter for the field
	 * @return : the myBookTitle
	 */
	public String getTitle() {
		return myBookTitle;
	}

	/**
	 * Getter for the field
	 * @return : the myAuthorsNames
	 */
	public ArrayList<String> getAuthors() {
		return myAuthorsNames;
	}

	/* 
	 * The toString() override
	 */
	@Override
	public String toString() {
		//TODO
		return "Book [myBookTitle=" + myBookTitle + 
				", myAuthorsNames=" + myAuthorsNames + "]";
	}
	
	/**
	 * This is another method that does things
	 * 
	 * @param theOther : 
	 * @return : 
	 */
	public int compareTo(final Book theOther) {
		//TODO
		return 0;
	}
	
	/**
	 * This is a method that does things
	 * 
	 * @param theOther : 
	 * @return : 
	 */
	public boolean equals(final Object theOther) {
		//TODO
		return true;
	}
}
