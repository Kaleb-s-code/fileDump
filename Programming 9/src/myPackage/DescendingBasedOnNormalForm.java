/**
 * Multiline comment at the top of the file.
 */
package myPackage;

import java.util.Comparator;

/**
 * This class is a comparator that checks for the order of the list 
 * passed to it. The purpose of this class is to change the order of the
 * list form Z-A, as opposed to A-Z. 
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 8, 2019 (Date of class creation) :
 */
public class DescendingBasedOnNormalForm implements Comparator<Word> {

	/**
	 * This is supposed to place the list in order from Z-A the words
	 * based on their normal forms.
	 * 
	 * @param  o1 : This is the word doing the comparing.
	 * @param  o2 : This is the word being compared.
	 * @return    : This method returns the nature of the comparison.
	 * 
	 */
	@Override
	public int compare(Word o1, Word o2) {
		int result = 0;
		if (o1.getMyOriginalWord().compareTo(o2.getMyOriginalWord()) < 0) {
			result = 1;
		} else if (o1.getMyOriginalWord()
				.compareTo(o2.getMyOriginalWord()) > 0) {
			result = -1;
		}
		return result;
	}
}
