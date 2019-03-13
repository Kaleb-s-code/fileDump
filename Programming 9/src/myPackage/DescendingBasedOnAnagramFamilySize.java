/**
 * Multiline comment at the top of the file.
 */
package myPackage;

import java.util.Comparator;
import java.util.Set;

/**
 * This is class is a comparator that attempts to organize a family of
 * anagrams in descending order based on the size of the family.
 *
 * @author  Kaleb Moreno (kalebm2@uw.edu)
 * @version Mar 8, 2019 (Date of class creation)
 */
public class DescendingBasedOnAnagramFamilySize implements Comparator<AnagramFamily> {

	/**
	 * This method is supposed to check for the size of the family and
	 * determine the difference between one families size against
	 * another's.
	 *
	 * @param  o1 : This is the object doing the comparing.
	 * @param  o2 : This is the object being compared.
	 * @return    : This method returns the nature of the comparison.
	 */
	@Override
	public int compare(AnagramFamily o1, AnagramFamily o2) {
		int result = 0;

		if (o1.getMyCurrentListSize() < o2.getMyCurrentListSize()) {
			result = 1;
		} else if (o1.getMyCurrentListSize() > o2.getMyCurrentListSize()) {
			result = -1;
		}
		return result;
	}
}
