/*
 * Multiline Comment
 */
//package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is the driver for two other classes "Library.java" and
 * "Book.java". This driver creates books by reading from an input
 * file, adds them to a Library and writes the books in different
 * orders to the output file. This class is also a tester of the other
 * classes' methods ensuring that things perform as they should.
 * 
 * My goal with this program was to avoid repeating code, and leverage
 * the principal of reusable code. This is why I split everything into
 * functions. My hope is that this is more readable than it would be
 * otherwise.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/14/2019
 */
public class LibraryDriver {

	/**
	 * This is the main method that makes all the initial calls to the
	 * various methods creating and opening files, and writing data. This
	 * method holds the three essential ArrayLists below which serve
	 * important functions in my version of this program.
	 * 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		Scanner inputFile = openTheInputFiles("LibraryIn1.txt");
		Scanner inputFile2 = openTheInputFiles("LibraryIn2.txt");
		PrintStream outputFile = openTheOutputFile("LibraryOut.txt");

		/*
		 * allTheAuthors : holds all of the authors in both files
		 * 
		 * authorHolding : is just a temporary holding for the authors read
		 * during the loops down below. The list holds the last book read upon
		 * completion.
		 * 
		 * driverBooks : Is an arrayList of all the book titles & authors in
		 * both the files after the second call to populateTheBooks().
		 */
		ArrayList<String> allTheAuthors = new ArrayList<String>();
		ArrayList<String> authorHolding = new ArrayList<String>();
		ArrayList<Book> driverBooks = new ArrayList<Book>();

		/*
		 * First call to the methods which add the books from the file And
		 * take care of adding to the library in addition to writing to the
		 * output file
		 */
		populateTheBooks(inputFile, allTheAuthors, authorHolding, driverBooks);
		Library library = writeUnsorted(driverBooks, outputFile, inputFile);
		writeSorted(library, outputFile);

		/*
		 * Second call to the methods which add the books from the second file
		 * And takes care of adding to the library in addition to writing to
		 * the output file.
		 */
		populateTheBooks(inputFile2, allTheAuthors, authorHolding, driverBooks);
		library = writeUnsorted(driverBooks, outputFile, inputFile2);
		writeSorted(library, outputFile);

		/*
		 * This method call adds a new book to the end of the library
		 * ArrayList. Each author must be separated by a semicolon ";" To
		 * display the new book in the list, uncomment out the writeSorted
		 * method below.
		 */
		addABookToLibrary(library, "NEW BOOK TITLE", "Bob, Jones;Terry, Cruse");
		// writeSorted(library, outputFile);

		/*
		 * These methods find the books in the library that match the String
		 * parameter passed to it. They then write that to the output file.
		 */
		writeMatchingBooks("Acer Dumpling", library, outputFile);
		writeMatchingBooks("The Bluff", library, outputFile);

		inputFile.close();
		inputFile2.close();
		outputFile.close();
	}

	/**
	 * This method simply opens an input file for reading.
	 * 
	 * @param theFile : This is the input file passed.
	 * @return : This method returns the open file.
	 */
	public static Scanner openTheInputFiles(String theFile) {
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new File(theFile));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}
		return inputFile;
	}

	/**
	 * This method just opens a file for writing the output.
	 * 
	 * @param theFile : This is the file passed.
	 * @return : This method returns the file to be written to.
	 */
	public static PrintStream openTheOutputFile(String theFile) {
		PrintStream outputFile = null;
		try {
			outputFile = new PrintStream(new File(theFile));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}
		return outputFile;
	}

	/**
	 * The purpose of this method is to take the input file and process
	 * all of the authors and book titles. A temporary ArrayList is used
	 * and cleared to create all of the the individual books from the
	 * file. My approach to using the unusual delimiter was to split the
	 * line based on that character.
	 * 
	 * @param theInputFile     : This is the input file passed.
	 * @param theAllTheAuthors : This is an ArrayList of all the authors
	 *                         read.
	 * @param theAuthorHolding : This is the temporary holding for the
	 *                         authors.
	 * @param theDriverBooks   : This is an ArrayList of all books
	 *                         created.
	 */
	public static void populateTheBooks(Scanner theInputFile, ArrayList<String> theAllTheAuthors,
			ArrayList<String> theAuthorHolding, ArrayList<Book> theDriverBooks) {
		Book book = new Book();
		while (theInputFile.hasNext()) {
			String title = theInputFile.nextLine();
			String[] tempAuthors = theInputFile.nextLine().split("\\*");
			for (int i = 0; i < tempAuthors.length; i++) {
				theAuthorHolding.add(tempAuthors[i]);
				theAllTheAuthors.add(tempAuthors[i]);
			}
			book = new Book(title, theAuthorHolding);
			theAuthorHolding.clear();
			theDriverBooks.add(book);
		}
	}

	/**
	 * The purpose of this method is to create the initial Library object
	 * that is used throughout the rest of the driver. This method also
	 * writes the unsorted list of books to the output file.
	 * 
	 * @param theDriverBooks : This is an ArrayList of all the books thus
	 *                       far.
	 * @param theOutputFile  : This is the output file.
	 * @param theInputFile   : This is the input file.
	 * @return : This method returns a Library object
	 */
	public static Library writeUnsorted(ArrayList<Book> theDriverBooks, PrintStream theOutputFile, Scanner theInputFile) {
		Library library = new Library(theDriverBooks);
		theOutputFile.print("PRINTS UNSORTED BOOK LIST:\n");
		theOutputFile.print(library.toString());
		theOutputFile.print("\n\n");
		return library;
	}

	/**
	 * The primary purpose of this method is to write the sorted Library
	 * to the output file. This is also where the actual sorting method is
	 * called.
	 * 
	 * @param theLibrary    : This is the Library object this far.
	 * @param theOutputFile : This is the output file to be written to.
	 */
	public static void writeSorted(Library theLibrary, PrintStream theOutputFile) {
		theLibrary.sort();
		theOutputFile.print("PRINTS SORTED BOOK LIST:\n");
		theOutputFile.print(theLibrary.toString());
		theOutputFile.print("\n\n");
	}

	/**
	 * The sole purpose of this method is to add single books to the end
	 * of the library ArrayList.
	 * 
	 * @param theLibrary : This is the passed library object
	 * @param theTitle   : This is the passed desired title
	 * @param theAuthors : This is the passed desired author(s)
	 */
	public static void addABookToLibrary(Library theLibrary, String theTitle, String theAuthors) {
		ArrayList<String> passedAuthor = new ArrayList<String>();
		String[] tempAuthors = new String[0];
		for (int i = 0; i < theAuthors.length(); i++) {
			tempAuthors = theAuthors.split(";");
		}
		for (int i = 0; i < tempAuthors.length; i++) {
			passedAuthor.add(tempAuthors[i]);
		}
		Book newBook = new Book(theTitle, passedAuthor);
		theLibrary.add(newBook);
	}

	/**
	 * The purpose of this method is to write the books which match a
	 * passed string to the output file.
	 * 
	 * @param theBookTitle  : This is the passed title to be matched.
	 * @param theLibrary    : This is the current Library object.
	 * @param theOutputFile : This is the output file.
	 */
	public static void writeMatchingBooks(String theBookTitle, Library theLibrary, PrintStream theOutputFile) {
		ArrayList<Book> matchedBook = theLibrary.findTitles(theBookTitle);
		String formattedString = "";
		theOutputFile.print("PRINTS ALL " + "\"" + theBookTitle.toUpperCase() + "\"s:\n");
		for (int i = 0; i < matchedBook.size(); i++) {
			formattedString += matchedBook.get(i) + "\n";
		}
		formattedString += "\n\n";
		theOutputFile.print(formattedString);
	}
}
