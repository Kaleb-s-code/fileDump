/**
 * Multiline comment at the top of the file.
 */
//package myPackage;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * This class is the driver for several other classes which accept an
 * input file, and create anagram families out of the words. These
 * families are then sorted in different ways and sent to an output
 * file.
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 8, 2019 (Date of class creation)
 */
public class Program9Driver {

	/**
	 * This is where the files are opened and all appropriate methods are
	 * called.
	 * 
	 * @param theArgs :
	 */
	public static void main(String[] theArgs) {
		long start = System.currentTimeMillis();
		Scanner inputFile = null;
		PrintStream outputFile = null;

		// Open the files
		try {
			inputFile = new Scanner(new File("words.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
		}

		try {
			outputFile = new PrintStream(new File("out9.txt"));
		} catch (Exception e) {
			System.out.println("Difficulties opening the file! " + e);
		}

		// Get the linked list of the words
		List<Word> theWordList = createTheLinkedListFromTheFile(inputFile);

		// Sort the linked list by canonical
		Collections.sort(theWordList);

		// Get the anagrams into a list
		List<AnagramFamily> theAnagramLinkedList = 
				createTheAnagramsLinkedList(theWordList);

		// This sorts the list in descending order based on the size of the
		// family
		theAnagramLinkedList.sort(new DescendingBasedOnAnagramFamilySize());

		// // This writes to the file
		outputToTheFile(outputFile, theAnagramLinkedList);

		// Close the files
		inputFile.close();
		outputFile.close();

		long end = System.currentTimeMillis() - start;
		System.out.println("Time to execute: " + end + " miliseconds");
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
	public static List<AnagramFamily> 
	createTheAnagramsLinkedList(List<Word> theWordList) {
		int counter = 0;
		Word nextWord = null;
		List<Word> anagramHolding = new ArrayList<Word>();
		List<AnagramFamily> anagramfamilyList =
				new LinkedList<AnagramFamily>();

		/*
		 * This initial loop begins the process of creating anagrams from the
		 * list.
		 */
		for (ListIterator<Word> iterator = theWordList.listIterator(); 
				iterator.hasNext();) {
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
			if (firstWord.compareTo(nextWord) == 0) {
				anagramHolding.add(firstWord);
				anagramHolding.add(nextWord);
				Word tempWord = iterator.next();
				while (nextWord.compareTo(tempWord) == 0) {
					anagramHolding.add(tempWord);
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
			} else {
				anagramHolding.add(firstWord);
				AnagramFamily anagramFamily = new AnagramFamily(anagramHolding);
				anagramfamilyList.add(anagramFamily);
			}
			anagramHolding.clear();
		}
		return anagramfamilyList;
	}

	/**
	 * This outputs the top five largest families then, all families of
	 * length 8, and lastly, the very last family stored.
	 *
	 * @param theOutFile    : This is the file to be written to.
	 * @param theSortedList : This is the sorted list of Anagrams.
	 */
	public static void outputToTheFile(PrintStream theOutFile, 
			List<AnagramFamily> theSortedList) {
		int i = 12;
		theOutFile.println("The Top 5 Largest Families:");
		for (ListIterator<AnagramFamily> iterator = theSortedList
				.listIterator(); iterator.hasNext() && i > 7;) {
			AnagramFamily tempWord = iterator.next();
			theOutFile.println(tempWord);
			i--;
		}
		theOutFile.println("\nFamilies of 8:");
		for (ListIterator<AnagramFamily> iterator = theSortedList
				.listIterator(); iterator.hasNext();) {
			AnagramFamily tempWord = iterator.next();
			while (tempWord.getMyCurrentListSize() == 8 && iterator.hasNext()) {
				theOutFile.println(tempWord);
				tempWord = iterator.next();
			}
		}
		theOutFile.println("\nLast Family:");
		theOutFile.println(theSortedList.get(theSortedList.size() - 1));
	}
}
