/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * This class does things and stuff that a class should do And there
 * are more things that it can do too.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 14, 2019
 */
public class PsTest {

	/**
	 * This method prints some stuff to and creates an output file
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String fileNameString = "someTestFile.txt";

		try {
			FileWriter fileWriter = new FileWriter(fileNameString);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Hello there sunny,");
			bufferedWriter.write(" This is a test.");
			bufferedWriter.newLine();
			bufferedWriter.write("Do you like what you see?");
			bufferedWriter.newLine();
			bufferedWriter.write("I cerntainly like what I do..");
			bufferedWriter.write("Is there a more efficient way of doing this?");

			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing to file " + fileNameString + "...");
		}
	}

}
