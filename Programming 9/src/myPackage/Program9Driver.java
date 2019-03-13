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
import java.util.ListIterator;
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

		// Get the anagrams into a list
		List<AnagramFamily> theAnagramLinkedList = createTheAnagramsLinkedList(theWordList);

		// // This sorts the list in descending order based on the size of the
		// family
		theAnagramLinkedList.sort(new DescendingBasedOnAnagramFamilySize());

		// for (Iterator iterator = theAnagramLinkedList.iterator();
		// iterator.hasNext();) {
		// AnagramFamily word = (AnagramFamily) iterator.next();
		// outputFile.println(word);
		// }

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
		int counter = 0;
		Word nextWord = null;
		List<Word> copiedList = new LinkedList<Word>();
		List<Word> anagramHolding = new ArrayList<Word>();
		List<AnagramFamily> anagramfamilyList = new LinkedList<AnagramFamily>();
		Word fish = null;
		// Deep copy of the list coming in..
		for (Iterator<Word> iterator = theWordList.iterator(); iterator.hasNext();) {

			Word wordInList = iterator.next();
			// System.out.println(wordInList);
			copiedList.add(wordInList.copyWord());
		}

		/*
		 * This initial loop begins the process of creating anagrams from the
		 * deep copied list.
		 */
		for (ListIterator<Word> iterator = copiedList.listIterator(); iterator.hasNext();) {
			counter++;
			Word firstWord = iterator.next();
			if (counter >= 2) {
				firstWord = nextWord;
				nextWord = iterator.previous();
			}
			if (iterator.hasNext()) {
				nextWord = iterator.next();
			}

			/*
			 * This initial check is for equality amongst a word and its
			 * neighbors.
			 */
			// System.out.println("Coming in: " + firstWord + ", " + nextWord);
			if (firstWord.compareTo(nextWord) == 0) {
				anagramHolding.add(firstWord);
				anagramHolding.add(nextWord);
				// System.out.println("EXACT MATCH: " + anagramHolding);
				Word tempWord = iterator.next();
				while (nextWord.compareTo(tempWord) == 0) {
					// System.out.println("****WHILE LOOP ENTERED****");
					anagramHolding.add(tempWord);
					// System.out.println(anagramHolding);
					tempWord = iterator.next();
				}
				iterator.previous();

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
				// System.out.println("Counter: " + counter);
			} else {
				anagramHolding.add(firstWord);
				// System.out.println("ELSE: " + anagramHolding);
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
		int i = 12;
		for (ListIterator<AnagramFamily> iterator = theSortedList.listIterator(); iterator.hasNext() && i != 8;) {
			counter++;
			AnagramFamily tempWord = iterator.next();
			if (tempWord.getMyCurrentListSize() == i) {
				theOutFile.println(tempWord);

				while (tempWord.getMyCurrentListSize() == i) {
					theOutFile.println(iterator.next());

				}

			}
			i--;
		}
		System.out.println(counter);
		System.out.println(i);
	}
}
