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
 * This class is the driver for several other classes. This driver seeks to make
 * three different shapes from an input file. A circle, a rectangle and a
 * Triangle. The driver then writes them to an output file in an unsorted and
 * sorted fashion.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 28, 2019
 */
public class Assignment7 {

	/**
	 * This is the main method in which all other methods are called, and the input
	 * and output files are closed.
	 * 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		Scanner inputFile = openTheInputFiles("in7.txt");
		PrintStream outputFile = openTheOutputFile("out7.txt");

		List<Shape> aList = new LinkedList<Shape>();
		List<Shape> populatedList = populateTheShapes(inputFile, aList);
		List<Shape> copiedList = copyTheList(populatedList);

		writeUnsorted(aList, outputFile);
		writeSorted(copiedList, outputFile);
		writeUnsorted(aList, outputFile);

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
	 * This method does the heavy lifting by looking at the file, determining what
	 * lines of input can be used to make shapes, then actually makes the shapes.
	 * 
	 * @param theInputFile : This is the input file passed.
	 * @param theShapes    : This is the LinkedList passed which will hold all of
	 *                     the shape objects.
	 * @return : This method returns the List that was passed via the parameter.
	 */
	public static List<Shape> populateTheShapes(Scanner theInputFile, List<Shape> theShapes) {

		String[] splitString;
		while (theInputFile.hasNext()) {
			splitString = theInputFile.nextLine().trim().split(" ");
			if (splitString.length < 2) {
				try {
					Double someNum = Double.valueOf(splitString[0]);
					Circle circle = new Circle(someNum);
					theShapes.add(circle);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (splitString.length > 1 && splitString.length < 3) {
				try {
					for (int i = 0; i < splitString.length; i++) {
						Double length = Double.valueOf(splitString[i]);
						i++;
						Double width = Double.valueOf(splitString[i]);
						Rectangle rectangle = new Rectangle(length, width);
						theShapes.add(rectangle);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				try {
					for (int i = 0; i < splitString.length; i++) {
						Double a = Double.valueOf(splitString[i]);
						i++;
						Double b = Double.valueOf(splitString[i]);
						i++;
						Double c = Double.valueOf(splitString[i]);
						Triangle triangle = new Triangle(a, b, c);
						theShapes.add(triangle);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return theShapes;
	}

	/**
	 * This method performs a deep copy of whatever list is passed to it.
	 * 
	 * @param theList : This is the list passed to be copied.
	 * @return : This method returns the deep copied list
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
	 * This method writes the objects to the output file in an unsorted fashion.
	 * 
	 * @param theShapes     : This is the list of shapes.
	 * @param theOutputFile : This is the file to be written to.
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
	 * This method writes to the output file in a sorted fashion based on the area
	 * of the shape.
	 * 
	 * @param theList       : This is the list passed.
	 * @param theOutputFile : this is the output file that will be written to.
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
