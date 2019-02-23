/*
 * Multiline comment at the top of the document
 */
//package myPackage;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is supposed to represent a book object in a library.
 * Upon instantiation, a title for each book is captured as well as
 * the author(s).
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/14/2019
 */
public class Book implements Comparable<Book> {

	/**
	 * Private field that holds the title of the book
	 */
	private String myBookTitle;

	/**
	 * Private field that holds the ArrayList of author names
	 */
	private ArrayList<String> myAuthorsNames;

	/**
	 * This is the constructor that uses a try catch block to check for
	 * invalid parameters and prints to the console a simple message
	 * indicating such. If successful, the fields are instantiated and
	 * assigned the legal values.
	 * 
	 * @param theTitle   : The title of the books
	 * @param theAuthors : The name of the author(s)
	 */
	public Book(final String theTitle, final ArrayList<String> theAuthors) {
		if (theTitle.isBlank() || theAuthors.isEmpty() || theAuthors == null) {
			throw new IllegalArgumentException();
		}
		myAuthorsNames = new ArrayList<String>();
		myAuthorsNames.addAll(theAuthors);
		myBookTitle = theTitle;
	}

	/**
	 * This is the overloaded Book constructor who's purpose is to allow
	 * instantiation of a book object, without having to set all of the
	 * fields. I only used this constructor once in the driver so that I
	 * could return book objects created in a loop.
	 */
	public Book() {
		myBookTitle = "";
	}

	/**
	 * This method is a getter for the book titles.
	 * 
	 * @return : This method returns the book title.
	 */
	public String getTitle() {
		return myBookTitle;
	}

	/**
	 * This method is a getter for the author's names.
	 * 
	 * @return : This method returns the authors names.
	 */
	public ArrayList<String> getAuthors() {
		return myAuthorsNames;
	}

	/**
	 * This is the compareTo method that compares two different objects
	 * and returns an integer value indicating the result.
	 * 
	 * @param theOther : This is the book to be checked.
	 * @return : This method returns the result indicating the nature of
	 *         equality.
	 */
	@Override
	public int compareTo(final Book theOther) {
		int result = 0;
		int titles = getTitle().compareTo(theOther.getTitle());
		boolean authors = getAuthors().equals(theOther.getAuthors());
		equals(theOther);
		if (titles < 0) {
			result = -1;
		} else if (titles > 0) {
			result = 1;
		} else if (titles == 0) {
			if (authors) {
				result = 0;
			} else if (!authors) {
				result = -1;
			}
		}
		return result;
	}

	/**
	 * This is the overridden equals method from the interface that does a
	 * number of sequential checks. Then finally returns a boolean
	 * indicating equality.
	 * 
	 * @param theOther : This is the object to be checked for equality.
	 * @return : This method returns a boolean indicating the nature of
	 *         equality.
	 */
	@Override
	public boolean equals(final Object theOther) {
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
		if ((theOther instanceof Book) == false) {
			// The type cast to Book
			Book book = (Book) theOther;
			result = (book.myBookTitle == myBookTitle && book.myAuthorsNames == myAuthorsNames);
		}
		return result;
	}

	/*
	 * This is the toString() method that builds a string and returns the
	 * Finished result.
	 */
	@Override
	public String toString() {
		String stringRep = "";
		for (int i = 0; i < myAuthorsNames.size(); i++) {
			stringRep += String.format("%s; ", myAuthorsNames.get(i));
		}
		return "\"" + myBookTitle + ",\"" + " by " + stringRep.substring(0, stringRep.length() - 2);
	}
}
