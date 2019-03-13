/**
 * Multiline comment at the top of the file.
 */
package myPackage;

import java.util.LinkedList;
import java.util.List;

/**
	* This is a description of what this class will do...
	*
 * @author Kaleb Moreno (kalebm2@uw.edu)
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
	 * @param myAnagrams
	 * @param myCurrentListSize : 
	 */
	public AnagramFamily(List<Word> theAnagrams) {
//		System.out.println(theAnagrams);
		myAnagrams = new LinkedList<Word>();
		myAnagrams.addAll(theAnagrams);
		myCurrentListSize = theAnagrams.size();
	}



	/**
		* This is a getter for..
		*
	 * @return the myAnagrams
	 */
	public List<Word> getMyAnagrams() {
		return myAnagrams;
	}

	
	/**
		* This is a getter for..
		*
	 * @return the myCurrentListSize
	 */
	public int getMyCurrentListSize() {
		return myCurrentListSize;
	}
	
	/**
	* This is an overidden method..
	*
 * 
 */
@Override
public String toString() {
	return "The Anagram Family: " + "'" + myAnagrams.get(getMyCurrentListSize() - 1).getMyCanonicalWord() + "', " + myAnagrams + " Size: " + myCurrentListSize;
}

	
}
