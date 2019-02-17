/*
 * Multiline Comment
 */
package myPackage;

import java.util.*;
import java.io.*;

/**
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/14/2019
 */
public class LibraryDriver {

	/**
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {

		 Scanner inputFile = null;
		 PrintStream outputFile = null;
		 try {
		 inputFile = new Scanner(new File("/LibraryIn1.txt"));
		 outputFile = new PrintStream(new File("LibraryOut.txt"));
		 } catch (Exception e) {
		 System.out.println("Difficulties opening the file! " + e);
		 System.exit(1);
		 }
		ArrayList<String> authors = new ArrayList<String>();
		ArrayList<Book> books = new ArrayList<Book>();
		

		
//		authors.add("Kaleb Moreno");
//		authors.add("cassandra moreno");
//		authors.add("Another author");
//		authors.add("Here is another author");
//		
//		Book aBook = new Book("Here comes the sun", authors);
//		Book bBook = new Book("Once upon a time", authors);
//		Book cBook = new Book("The cat in the hat", authors);
//		Book dBook = new Book("Moby Dick", authors);
//		Book eBook = new Book("A night's day", authors);
//		
////		System.out.println(authors.toString());
//		System.out.println(aBook.toString());
//		System.out.println(bBook.toString());
//		System.out.println(cBook.toString());
//		System.out.println(dBook.toString());
//		System.out.println(eBook.toString());
//		
		String readBooks = "";
		String readAuthors = "";
		 while (inputFile.hasNext()) {
		 	readBooks = inputFile.nextLine();
		 	readAuthors = inputFile.nextLine();
		 // Read title
		 // Read author(s)
		 // Insert title & author(s)into a book
		 // Add this book to the ArrayList<Book> of books
		 }
//		 Instantiate a Library object filled with the books read thus far
//		 and write the contents of the library to the output file
//
//		 Sort the current contents of the library
//		 and write the contents of the sorted library to the output file
//		 Close the first input file and open the second input file.
//		 Read the titles and authors from the second input file,
//		 add them to the library, and write the contents of the
//		 library to the output file.
//		 inputFile.close();
		
		 // . . . etc.
		
		 // Sort the library and write it to the output file
		
		 // The following tests the findTitles method, i.e. test
		 // the findTitles method by passing “Acer Dumpling” and
		 // then “The Bluff”:
		 // Write only the "Acer Dumpling" books to the output file
		
		 // Write only the "The Bluff" books to the output file
		
		 // Close all open files and end main.
		 inputFile.close();
		 outputFile.close();
		 System.out.println(readBooks);
		 System.out.println(readAuthors);
	}

	// Header for method that separates author names and
	// returns an ArrayList<String> containing the author names
//	public static ArrayList<String> getAuthors(String theAuthors) {
//		// YOU FILL IN THE DETAILS HERE
//	}
}
