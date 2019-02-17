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
		// Opening the files for input and output
		Scanner inputFile = null;
		Scanner inputFile2 = null;
		PrintStream outputFile = null;

		// Catching an Exception and creating new objects
		try {
			inputFile = new Scanner(new File("LibraryIn1.txt"));
			outputFile = new PrintStream(new File("LibraryOut.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}
		/*
		 * allTheAuthors : holds all of the authors in whatever file
		 * authorHolding : is just a temporary holding for the authors read
		 * during the loops down below. The list is empty upon completion.
		 * books : Is an arrayList of all the book titles & authors in the
		 * file
		 */
		ArrayList<String> allTheAuthors = new ArrayList<String>();
		ArrayList<String> authorHolding = new ArrayList<String>();
		ArrayList<Book> driverBooks = new ArrayList<Book>();

		populateTheBooks(inputFile, allTheAuthors, authorHolding, driverBooks);
		dealWithTheLibrary(driverBooks, outputFile, inputFile);

		try {
			inputFile2 = new Scanner(new File("LibraryIn2.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}

//		ArrayList<String> allTheAuthors2 = new ArrayList<String>();
		ArrayList<String> authorHolding2 = new ArrayList<String>();
		ArrayList<Book> driverBooks2 = new ArrayList<Book>();

		populateTheBooks(inputFile2, allTheAuthors, authorHolding2, driverBooks2);
		dealWithTheLibrary(driverBooks2, outputFile, inputFile2);
		

		outputFile.close();
	}

	/**
	 * 
	 * @param inputFile
	 * @param allTheAuthors
	 * @param authorHolding
	 * @param driverBooks
	 */
	public static void populateTheBooks(Scanner inputFile, ArrayList<String> allTheAuthors,
			ArrayList<String> authorHolding, ArrayList<Book> driverBooks) {

		while (inputFile.hasNext()) {
			String title = inputFile.nextLine();
			String[] tempAuthors = inputFile.nextLine().split("\\*");
			for (int i = 0; i < tempAuthors.length; i++) {
				authorHolding.add(tempAuthors[i]);
				allTheAuthors.add(tempAuthors[i]);
			}
			Book book = new Book(title, authorHolding);
			authorHolding.clear();
			driverBooks.add(book);
		}
	}

	/**
	 * 
	 * @param driverBooks
	 * @param outputFile
	 * @param inputFile
	 */
	public static void dealWithTheLibrary(ArrayList<Book> driverBooks, PrintStream outputFile, Scanner inputFile) {
		// Instantiate a Library object filled with the books read thus far
		// and write the contents of the library to the output file
		// Sort the current contents of the library
		// and write the contents of the sorted library to the output file
		Library library = new Library(driverBooks);

		outputFile.print("\n\n" + "PRINTS INITIAL BOOK LIST:\n");
		outputFile.print(library.toString());

		library.sort();
		outputFile.print("\n\n");
		outputFile.print("PRINTS SORTED BOOK LIST:\n");
		outputFile.print(library.toString());

		inputFile.close();
	}

//	 public static ArrayList<String> getAuthors(String theAuthors) {
//	 	
//	 }

}
