/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;
import java.util.Objects;


/**
 * This class is supposed to represent a book object in a library.
 * Upon instantiation, a title  for each book is captured 
 * as well as the author(s).
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
		try {
			myAuthorsNames = new ArrayList<String>();
			myAuthorsNames.addAll(theAuthors);
			myBookTitle = theTitle;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Parameters: " + e);
		}
	
	}

	/**
	 * Getter for the titles
	 * 
	 * @return : myBookTitle
	 */
	public String getTitle() {
		return myBookTitle;
	}

	/**
	 * Getter for the authors
	 * 
	 * @return : myAuthorsNames
	 */
	public ArrayList<String> getAuthors() {
		return myAuthorsNames;
	}

	/**
	 * This is the compareTo method that compares two different objects
	 * and returns an integer value indicating the result.
	 * 
	 * @param theOther :
	 * @return : integer
	 */
	@Override
	public int compareTo(final Book theOther) {
		int result = 0;
		int titles = getTitle().compareTo(theOther.getTitle());
		boolean authors = getAuthors().equals(theOther.getAuthors());
		
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
	 * This is the overridden equals method from the interface that does 
	 * a number of sequential checks. Then finally returns a boolean
	 * indicating equality. 
	 * 
	 * @param theOther :
	 * @return : boolean
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

		// The type cast to Book
		Book book = (Book) theOther;

		// Checking for equality amongst instances
		if ((book instanceof Book) == false) {
			result = false;
		}

		// Checking for book title first, then the author's names
		if (Objects.equals(myBookTitle, book.myBookTitle) && 
				Objects.equals(myAuthorsNames, book.myAuthorsNames)) {
			result = true;
		}
		return result;
	}
	
	/*
	 * The toString() override
	 */
	@Override
	public String toString() {
		// TODO
		return "Book [myBookTitle=" + myBookTitle +
				", myAuthorsNames=" + myAuthorsNames + "]";
	}
}
