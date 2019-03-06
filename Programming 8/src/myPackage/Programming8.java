/**
 * Multiline comment at the top of the file.
 */
package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This program is to read all the words contained in the input file,
 * one at a time recursively until no words remain. Then print the 
 * results of a set and map to an output file.
 * 
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 2, 2019 (Date of class creation)
 */
public class Programming8 {

	/**
	 * This main method calls a number of other methods that first 
	 * get the string of words from the input file. Then it creates a 
	 * set out of those words. Then a map. finally, it outputs the results
	 * to an outfile. 
	 *
	 * @param theArgs :
	 */
	public static void main(String[] theArgs) {
		Scanner inputFile = openTheInputFiles("in8.txt");
		PrintStream outputFile = openTheOutputFile("out8.txt");

		// This is where you put the letter you're looking for
		char theChar = 'a';

		String stringOfWordString = getWordsString(inputFile, theChar);

		Set<String> wordSet = getWordSet(stringOfWordString);

		Map<Integer, Set<String>> wordMap = getWordLengthMap(wordSet);

		writeToTheFile(outputFile, wordSet, wordMap, theChar);

		inputFile.close();
		outputFile.close();
	}

	/**
	 * This method simply opens an input file for reading.
	 * 
	 * @param  theFile : This is the input file passed.
	 * @return         : This method returns the open file.
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
	 * @param  theFile : This is the file passed.
	 * @return         : This method returns the file to be written to.
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
	 * This method gets the String of words from the input file and checks
	 * if any of the words contain the passed char via another method.
	 *
	 * @param  theInputFile : This is the input file passed.
	 * @param  theChar      : This is the character to be searched for.
	 * @return              : This method returns a string containing all
	 *                      of the words that have the character.
	 */
	public static String getWordsString(final Scanner theInputFile, 
			final char theChar) {
		String resultString = "";
		String tempString = "";
		if (theInputFile.hasNext()) {
			tempString = theInputFile.next();
			if (hasCharacter(tempString.toLowerCase(), theChar)) {
				resultString = tempString + " " + 
			getWordsString(theInputFile, theChar);
			} else {
				resultString = getWordsString(theInputFile, theChar);
			}
		}
		return resultString;
	}

	/**
	 * This method checks to see if the word passed contains the character
	 * any where in the string of letters. It does this by removing a
	 * piece of the word until all characters have been checked.
	 *
	 * 
	 * @param  theWord : This is the word to be broken down.
	 * @param  theChar : This is the char to be checked against.
	 * @return         : This method returns whether or not the char is in
	 *                 the string.
	 */
	public static boolean hasCharacter(final String theWord, 
			final char theChar) {
		int i = 0;
		if (theWord.charAt(i) == theChar) {
			return true;
		} else if (theWord.length() > 1) {
			return hasCharacter(theWord.substring(1), theChar);
		}
		return false;
	}

	/**
	 * This is a what this method is a helper method to the overloaded
	 * method below.
	 *
	 * @param  theWords : This is a string of words from the input file.
	 * @return          : returns a Set of type string.
	 */
	public static Set<String> getWordSet(final String theWords) {
		Set<String> theWordSet = new TreeSet<String>();
		return getWordSet(theWords, theWordSet);
	}

	/**
	 * This method converts all of the words into a set of type string.
	 *
	 * @param  theWords   : These are the words passed to be converted.
	 * @param  theWordSet : This is the TreeSet passed from the helper
	 *                    method.
	 * @return            : This method returns a Set of type string.
	 */
	public static Set<String> getWordSet(final String theWords, 
			Set<String> theWordSet) {
		Set<String> tempSet = new TreeSet<String>();
		String aWord = theWords.substring(0, theWords.indexOf(" ") + 1);
		int theSpace = theWords.indexOf(" ");
		tempSet.add(aWord);
		if (theWords.length() < 1) {
			return theWordSet;
		} else {
			tempSet.addAll(getWordSet(theWords.substring(theSpace + 1)));
			theWordSet.addAll(tempSet);
		}
		return theWordSet;
	}

	/**
	 * This is the helper method to the method directly below. This method
	 * passes an instantiated TreeMap and iterator to the overloaded
	 * method so that the set can be placed into a map of like terms.
	 *
	 * @param  theSet : This is the set passed.
	 * @return        : This method returns a Map of Sets.
	 */
	public static Map<Integer, Set<String>> getWordLengthMap(
			Set<String> theSet) {
		if (!theSet.isEmpty()) {
			Map<Integer, Set<String>> theMap = new TreeMap<Integer, 
					Set<String>>();
			Iterator<String> itr = theSet.iterator();
			return getWordLengthMap(theMap, itr);
		} else {
			return null;
		}
	}

	/**
	 * This method does the actual converting. It takes the iterator and
	 * the map object then adds to it the words which match the length of
	 * the key.
	 *
	 * @param  theMap : This is the map passed.
	 * @param  itr    : This is the iterator.
	 * @return        : This method returns a map of Sets.
	 */
	public static Map<Integer, Set<String>> getWordLengthMap(
			Map<Integer, Set<String>> theMap, Iterator<String> itr) {
		Set<String> tempSet = new TreeSet<String>();
		String theNextWordString = itr.next();
		int key = theNextWordString.length();
		tempSet.add(theNextWordString);
		if (!itr.hasNext()) {
			return theMap;
		} else {
			getWordLengthMap(theMap, itr);
			if (theMap.get(key) != null) {
				tempSet.addAll(theMap.get(key));
				theMap.put(key, tempSet);
			} else {
				theMap.put(key, tempSet);
			}
		}
		return theMap;
	}

	/**
	 * This method is responsible for getting the set and Map information
	 * to the output file.
	 *
	 * @param theOutputFile : This is the file to be written to.
	 * @param theSet        : This is the set to be written.
	 * @param theMap        : This is the map to be written.
	 * @param theChar       : This is the char to be written, so that the
	 *                      header reflects the proper search char.
	 */
	public static void writeToTheFile(
			PrintStream theOutputFile, Set<String> theSet, 
			Map<Integer, Set<String>> theMap,
			char theChar) {
		if (!theSet.isEmpty()) {
			theOutputFile.print("Set Size=" + theSet.size());
			theOutputFile.print("\nSet of words containing the letter " 
			+ theChar + ": ");
			theOutputFile.print("\n" + theSet);
			theOutputFile.print("\n\nMap Size=" + theMap.size());
			theOutputFile.print("\nMap of words containing the letter " 
			+ theChar + ": ");
			theOutputFile.print("\n" + theMap);
		} else {
			System.out.println("**Character not found in the file.**\n"
					+ "     Try a lower case letter.");
		}
	}
}
