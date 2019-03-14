/**
 * Multiline comment at the top of the file.
 */
//package myPackage;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is responsible for creating the anagram families.
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 8, 2019 (Date of class creation)
 */
public class AnagramFamily {

	/**
	 * This field holds the List of anagrams.
	 */
	private List<Word> myAnagrams;

	/**
	 * This field represents the amount of items in the List.
	 */
	private int myCurrentListSize;

	/**
	 * This is a constructor that receives a
	 *
	 * @param theAnagrams : This is a list of anagrams passed.
	 */
	public AnagramFamily(List<Word> theAnagrams) {
		myAnagrams = new LinkedList<Word>();
		myAnagrams.addAll(theAnagrams);
		myCurrentListSize = theAnagrams.size();
	}

	/**
	 * This is a getter for the anagrams.
	 *
	 * @return : this returns myAnagrams.
	 */
	public List<Word> getMyAnagrams() {
		return myAnagrams;
	}

	/**
	 * This is a getter for the list size.
	 *
	 * @return : This returns myCurrentListSize.
	 */
	public int getMyCurrentListSize() {
		return myCurrentListSize;
	}

	/**
	 * This method is used in a Comparator to sort by the canonical
	 * versions of the words.
	 *
	 * @return : This method returns the canonical word of the last item
	 *         in the anagram list.
	 */
	public String getTheComparisonWord() {
		return getMyAnagrams().get(getMyCurrentListSize() - 1)
				.getMyCanonicalWord();
	}

	/**
	 * This is the toString()
	 *
	 * @return : This method returns a string representation of the
	 *         object.
	 */
	@Override
	public String toString() {
		return String.format("Family: %-8s Length: %5d %5s",
				getMyAnagrams().get(getMyCurrentListSize() - 1)
				.getMyCanonicalWord(), myCurrentListSize, myAnagrams);
	}

}
