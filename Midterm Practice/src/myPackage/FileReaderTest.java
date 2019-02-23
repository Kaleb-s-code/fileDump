/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
	*	This class does things and stuff that a class should do 
 * And there are more things that it can do too.
	*
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 *	@version : Feb 14, 2019
 */
public class FileReaderTest {

	/**
	 * This class reads from a text file and prints the lines
	 * to the console.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String fileNameString = "sample.txt";
		
		String lineString = null;
		
		try {
			FileReader fileReader = new FileReader(fileNameString);
			BufferedReader buffReader = new BufferedReader(fileReader);
			
			while ((lineString = buffReader.readLine()) != null) {
				System.out.println(lineString);
			}
			buffReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found!");
		}
		catch (IOException e) {
			System.out.println("Error reading file");
		}

	}

}
