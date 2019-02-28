/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class does things and stuff that a class should do And there are more
 * things that it can do too.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 23, 2019
 */
public class Assignment7 {

	/**
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		Scanner inputFile = openTheInputFiles("in7.txt");
		PrintStream outputFile = openTheOutputFile("out7.txt");

		List<Shape> myList = new LinkedList<Shape>();
		List<Shape> copyList = populateTheShapes(inputFile, myList);

		writeUnsorted(myList, outputFile);
		writeSorted(copyList, outputFile);
		writeUnsorted(myList, outputFile);
		
		
		copyTheList(myList);

		inputFile.close();
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
	 * 
	 * @param theInputFile
	 */
	public static ArrayList<Shape> populateTheShapes(Scanner theInputFile, List<Shape> theShapes) {

		ArrayList<Shape> copyList = new ArrayList<Shape>();

		String[] splitString;
		while (theInputFile.hasNext()) {
			String string = theInputFile.nextLine().strip();
			if (string.length() < 4 && !string.isEmpty() && string.length() != 3
					|| string.length() == 3 && string.contains(".")) {
				try {
					Double someNum = Double.valueOf(string);
					Circle circle = new Circle(someNum);
					theShapes.add(circle);
					copyList.add(circle);
				} catch (IllegalArgumentException e) {
					 System.out.println(e);
				}
			}

			else if (!string.isEmpty()) {
				splitString = string.split(" ");
				if (splitString.length < 3) {
					try {
						for (int i = 0; i < splitString.length; i++) {
							Double length = Double.valueOf(splitString[i]);
							i++;
							Double width = Double.valueOf(splitString[i]);
							Rectangle rectangle = new Rectangle(length, width);
							theShapes.add(rectangle);
							copyList.add(rectangle);
						}
					} catch (IllegalArgumentException e) {
						 System.out.println(e);

					}

				}
				if (splitString.length >= 3) {
					try {
						for (int i = 0; i < splitString.length; i++) {
							Double a = Double.valueOf(splitString[i]);
							i++;
							Double b = Double.valueOf(splitString[i]);
							i++;
							Double c = Double.valueOf(splitString[i]);
							Triangle triangle = new Triangle(a, b, c);
							theShapes.add(triangle);
							copyList.add(triangle);
						}
					} catch (IllegalArgumentException e) {
						 System.out.println(e);
					}
				}
			}
		}
		return copyList;
	}

	/**
	 * 
	 * @param theInputFile
	 * @param theList
	 * @return
	 */
	public static List<Shape> copyTheList(List<Shape> theList) {
		List<Shape> newList = new ArrayList<Shape>();
		for (Shape shape : theList) {
			Shape s = shape.copyShape();
			newList.add(s);
		}
		return newList;

	}

	/**
	 * 
	 * 
	 * @param theDriverBooks
	 * @param theOutputFile
	 * @param theInputFile
	 * @return
	 */
	public static void writeUnsorted(List<Shape> theShapes, PrintStream theOutputFile) {
		Iterator<Shape> itr = theShapes.iterator();

		theOutputFile.print("Original List [unsorted]:\n");
		while (itr.hasNext()) {
			theOutputFile.print(itr.next() + "\n");
		}
		theOutputFile.print("\n");
	}

	/**
	 * The primary purpose of this method is to write the sorted Library to the
	 * output file. This is also where the actual sorting method is called.
	 * 
	 * @param theLibrary    : This is the Library object this far.
	 * @param theOutputFile : This is the output file to be written to.
	 */
	public static void writeSorted(List<Shape> theList, PrintStream theOutputFile) {
		
		Collections.sort(theList);
		Iterator<Shape> itr = theList.iterator();
		theOutputFile.print("Copied List [sorted]:\n");
		while (itr.hasNext()) {
			theOutputFile.print(itr.next() + "\n");
		}
		theOutputFile.print("\n");
	}

}
