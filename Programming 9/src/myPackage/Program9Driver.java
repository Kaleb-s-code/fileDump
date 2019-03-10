/**
 * Multiline comment at the top of the file.
 */
package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * This is a description of what this class will do...
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 8, 2019 (Date of class creation)
 */
public class Program9Driver {

	/**
	 * Step 1
	 * 
	 * This Driver should create a LinkedList of Word objects using all
	 * the words found in the input file "words.txt".
	 * 
	 * Step 2
	 * 
	 * Using an Iterator on the LinkedList of Word, create a 2nd list (new
	 * LinkedList) consisting of objects of a new class named
	 * AnagramFamily.
	 * 
	 * Step 3
	 * 
	 * Sort the AnagramFamily LinkedList in descending order based on
	 * family size by use of a Comparator to be passed to the Collections
	 * sort method.
	 * 
	 * Step 4
	 * 
	 * Next, output the top five largest families then, all families of
	 * length 8, and lastly, the very last family stored in the list to a
	 * file named “out9.txt.” Be sure to format the output to be very
	 * clear and meaningful.
	 * 
	 * 
	 * @param theArgs :
	 */
	public static void main(String[] theArgs) {
		long start = System.currentTimeMillis();

		// Open the files
		Scanner inputFile = openTheInputFile("words.txt");
		PrintStream outputFile = openTheOutputFile("out9.txt");

		// Get the linked list of the words
		List<Word> theWordList = createTheLinkedListFromTheFile(inputFile);

		// Sort the linked list by canonical
		Collections.sort(theWordList);

		// for (Iterator iterator = theWordList.iterator();
		// iterator.hasNext();) {
		// Word word = (Word) iterator.next();
		// System.out.println(word.getMyCanonicalWord());
		// }

		// Get the anagrams into a list
		List<AnagramFamily> theAnagramLinkedList = createTheAnagramsLinkedList(theWordList);

		// // This sorts the list in descending order based on the size of the
		// family
		theAnagramLinkedList.sort(new DescendingBasedOnAnagramFamilySize());
		//
		//
		// // This writes to the file
		outputToTheFile(outputFile, theAnagramLinkedList);

		// Close the files
		inputFile.close();
		outputFile.close();

		long end = System.currentTimeMillis() - start;
		System.out.println("Time to execute: " + end + " miliseconds");
	}

	/**
	 * This method simply opens an input file for reading.
	 * 
	 * @param  theFile : This is the input file passed.
	 * @return         : This method returns the open file.
	 */
	public static Scanner openTheInputFile(String theFile) {
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
	 * This method should create a linked list of word objects form the
	 * words in the file.
	 *
	 * @param  theFile : This is the file object to be processed.
	 * @return         : This method returns a LinkedList of type Word.
	 */
	public static List<Word> createTheLinkedListFromTheFile(Scanner theFile) {
		List<Word> listOfTheWordsInTheFile = new LinkedList<Word>();
		while (theFile.hasNext()) {
			Word word = new Word(theFile.next());
			listOfTheWordsInTheFile.add(word);
		}
		return listOfTheWordsInTheFile;
	}

	/**
	 * This method will receive a list of word objects and create a new
	 * list from that list of anagrams.
	 *
	 * @param  theWordList : This is a linked list of words.
	 * @return             : This method should return the List of
	 *                     Anagrams.
	 */
	public static List<AnagramFamily> createTheAnagramsLinkedList(List<Word> theWordList) {
		Word nextWord = null;
		int counter = 0;
		List<Word> copiedList = new LinkedList<Word>();
		List<Word> anagramHolding = new ArrayList<Word>();
		List<AnagramFamily> anagramfamilyList = new LinkedList<AnagramFamily>();

		// Deep copy of the list coming in..
		for (Iterator<Word> iterator = theWordList.iterator(); iterator.hasNext();) {
			Word wordInList = iterator.next();
			counter++;
			copiedList.add(wordInList.copyWord());
		}
		System.out.println("TOTAL WORD COUNT: " + counter);
		/*
		 * This initial loop begins the process of creating anagrams from the
		 * deep copied list.
		 */
		for (Iterator<Word> iterator = copiedList.iterator(); iterator.hasNext();) {
			Word word = iterator.next();
			if (iterator.hasNext()) {
				nextWord = iterator.next();
			}
			/*
			 * This initial check is for equality amongst a word and its
			 * neighbors.
			 */
			if (word.compareTo(nextWord) == 0) {
				anagramHolding.add(word);
				anagramHolding.add(nextWord);
				Word furtherTests = iterator.next();
				while (nextWord.compareTo(furtherTests) == 0) {
					anagramHolding.add(furtherTests);
					furtherTests = iterator.next();
				}

				/*
				 * This sorts each item from the list from Z-A before being added to
				 * the anagramFamily.
				 */
				anagramHolding.sort(new DescendingBasedOnNormalForm());

				// Actual creation of an anagram family.
				AnagramFamily anagramFamily = new AnagramFamily(anagramHolding);
				anagramfamilyList.add(anagramFamily);

				/*
				 * This next check adds any words that do not have a neighbor who
				 * matches their canonical form.
				 */
			} else {
				anagramHolding.add(word);

				// Actual creation of an anagram family.
				AnagramFamily anagramFamily = new AnagramFamily(anagramHolding);
				anagramfamilyList.add(anagramFamily);
			}
			anagramHolding.clear();
		}
		return anagramfamilyList;
	}

	/**
	 * Next, output the top five largest families then, all families of
	 * length 8, and lastly, the very last family stored in the list to a
	 * file named “out9.txt.”
	 *
	 * @param theOutFile    : This is the file to be written to.
	 * @param theSortedList : This is the sorted list of Anagrams.
	 */
	public static void outputToTheFile(PrintStream theOutFile, List<AnagramFamily> theSortedList) {
		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;
		int counter6 = 0;
		int counter7 = 0;
		int counter8 = 0;
		int counter9 = 0;
		int counter10 = 0;
		int counter11 = 0;

		for (Iterator<AnagramFamily> iterator = theSortedList.iterator(); iterator.hasNext();) {
			AnagramFamily anagramFamily = (AnagramFamily) iterator.next();

			if (anagramFamily.getMyCurrentListSize() == 1) {
				counter++;
			} else if (anagramFamily.getMyCurrentListSize() == 2) {
				counter2++;
			} else if (anagramFamily.getMyCurrentListSize() == 3) {
				counter3++;
			} else if (anagramFamily.getMyCurrentListSize() == 4) {
				counter4++;
			} else if (anagramFamily.getMyCurrentListSize() == 5) {
				counter5++;
			} else if (anagramFamily.getMyCurrentListSize() == 6) {
				counter6++;
			} else if (anagramFamily.getMyCurrentListSize() == 7) {
				counter7++;
			} else if (anagramFamily.getMyCurrentListSize() == 8) {
				counter8++;
			} else if (anagramFamily.getMyCurrentListSize() == 9) {
				counter9++;
			} else if (anagramFamily.getMyCurrentListSize() == 10) {
				counter10++;
			} else if (anagramFamily.getMyCurrentListSize() == 11) {
				counter11++;
			}
		}

		System.out.println("Size 1: " + counter);
		System.out.println("Size 2: " + counter2);
		System.out.println("Size 3: " + counter3);
		System.out.println("Size 4: " + counter4);
		System.out.println("Size 5: " + counter5);
		System.out.println("Size 6: " + counter6);
		System.out.println("Size 7: " + counter7);
		System.out.println("Size 8: " + counter8);
		System.out.println("Size 9: " + counter9);
		System.out.println("Size 10: " + counter10);
		System.out.println("Size 11: " + counter11);
		
		System.out.println();
		System.out.println(counter + (counter2 * 2) + (counter3 * 3) + 
				(counter4 * 4) + (counter5 * 5) + (counter6 * 6) + (counter7 * 7) + (counter8 * 8) + 
				(counter9 * 9) + (counter10 * 10) + (counter11 * 11));

	}
}
