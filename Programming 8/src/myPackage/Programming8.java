/**
 * Multiline comment at the top of the file.
 */
//package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This program is to read all the words contained in the input file,
 * one at a time recursively until no words remain. To do this main
 * will call a recursive method named getWordsString (discussed
 * shortly) which is passed a Scanner to a File object and a single
 * character. getWordsString will read all the words in the file and
 * return a String containing all words from the input file that
 * contain a single given character, perhaps the character ‘a’.
 * 
 * getWordString will use the recursive method hasCharacter to
 * determine if the current word needs to be added to the String. Keep
 * in mind, this string must have a single space inserted between each
 * word. In order to remove redundant words, the String returned from
 * getWordsString will be sent to another recursive method
 * “getWordSet” which will ‘pick’ out each word in the String and add
 * them to a TreeSet (this will remove all duplicates and, as a
 * TreeSet, will align the words in sorted order). The TreeSet will be
 * returned to main for final output. Details on getWordSet are listed
 * below.
 * 
 * Before outputting the results, main will pass the TreeSet of words
 * to the non-recursive helper method getWordLengthMap which in turn,
 * returns a call to the recursive version of this method of the same
 * name to produce a Map (instantiated as a TreeMap) of word lengths
 * to a set of words of that same length.
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 2, 2019 (Date of class creation)
 */
public class Programming8 {

	/**
	 * This is a field
	 */
	private static String myString;

	/**
	 * This is a field
	 */
	private static Set<String> mySet;
	/**
	 * This program is to read all the words contained in the input file,
	 * one at a time recursively until no words remain. To do this main
	 * will call a recursive method named getWordsString which is passed a
	 * Scanner to a File object and a single character. getWordsString
	 * will read all the words in the file and return a String containing
	 * all words from the input file that contain a single given
	 * character.
	 *
	 * @param theArgs :
	 */
	public static void main(String[] theArgs) {
		mySet = new TreeSet<String>();
		Scanner inputFile = openTheInputFiles("in8.txt");
		PrintStream outputFile = openTheOutputFile("out8.txt");

		getWordsString(inputFile, 'a');
		getWordSet(myString);
		 
		getWordLengthMap(mySet);
		
		System.out.println(mySet.toString());

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
	 * Recursively read all the words contained in the input file and
	 * return a String containing only the words found in the file that
	 * contain a given char (The words within this String will be
	 * separated by a space). Multiple return statements will be allowed
	 * here.
	 *
	 * @param  theInputFile
	 * @return              :
	 */
	public static String getWordsString(final Scanner theInputFile, final char theChar) {
		String resultString = "";
		String tempString = "";
		if (theInputFile.hasNext()) {
			tempString = theInputFile.next();
			if (hasCharacter(tempString.toLowerCase(), theChar)) {
				myString += tempString + " ";
			}
			getWordsString(theInputFile, theChar);
		}
		// getWordSet(resultString);
		System.out.print(resultString);
		return resultString;
	}

	/**
	 * Recursively scan the characters within a received word to see if it
	 * contains a given char and return true if it does, false otherwise
	 *
	 * @param  theWord
	 * @return         :
	 */
	public static boolean hasCharacter(final String theWord, final char theChar) {
		int i = 0;
		if (theWord.charAt(i) == theChar) {
			return true;
		} else if (theWord.length() > 1) {
			return hasCharacter(theWord.substring(1), theChar);
		}
		return false;
	}

	/**
	 * Recursively scan the words in a received String where each word is
	 * separated by a space and placing each word into a Set (TreeSet)
	 * which is returned to the calling program once all the words have
	 * been scanned. Multiple return statements will be allowed here
	 *
	 * @param  theWords
	 * @return          :
	 */
	public static Set<String> getWordSet(final String theWords) {
		Set<String> theWordSet = new TreeSet<String>();
//		theWordSet.add(theWords.substring(0, theWords.indexOf(" ") + 1));
//		System.out.println(theWordSet.toString());

		if (theWords.length() < 1) {
			return null;
		} else {
			int theSpace = theWords.indexOf(" ");
			
			getWordSet(theWords.substring(theSpace + 1));
			mySet.add((theWords.substring(0, theWords.indexOf(" ") + 1)));

		}
		return theWordSet;
	}

	/**
	 * Recursively scan the set created by getWordSet and generate a
	 * Map<Integer, Set<String>> that Maps the length of a word to a Set
	 * of words of that length, i.e. a length of a given word will use
	 * this length as a key and add the given word to a Set to which the
	 * key maps. This solution implies the use of a non-recursive
	 * overloaded helper method of the same name called by main, that
	 * simply receives the Set created by getWordSet and in it,
	 * instantiates a Map of Integer to a Set of String which should then
	 * call the recursive version of getWordLengthMap passing it the Map
	 * it creates and an Iterator on the Set which it receives. :
	 */
	
	/**
	 * The helper method to the getLengthMap
	 * 
	 * @param theSet
	 * @return
	 */
	public static Map<Integer, Set<String>> getWordLengthMap(Set<String> theSet) {
		Map<Integer, Set<String>> theMap = new TreeMap<Integer, Set<String>>();
		return theMap;
	}
	
	/**
	 * The meat and potatoes of the getWordLengthMap
	 * 
	 * @param theWordLengths
	 * @param theWordSetItr
	 * @return
	 */
	public static Map<Integer, Set<String>> getWordLengthMap(Map<Integer, 
			Set<String>> theWordLengths, 
			Iterator<String> theWordSetItr) {
		return theWordLengths;
	}

	/**
	 * This method writes the objects to the output file in an unsorted
	 * fashion.
	 * 
	 * @param theShapes     : This is the list of shapes.
	 * @param theOutputFile : This is the file to be written to.
	 */
	public static void writeToTheFile(PrintStream theOutputFile) {
		// Iterator<Shape> itr = theShapes.iterator();
		//
		// theOutputFile.print("Original List [unsorted]:\n");
		// while (itr.hasNext()) {
		// theOutputFile.print(itr.next() + "\n");
		// }
		// theOutputFile.print("\n");
		// }

	}
}
