/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;

/**
 * This class contains the logic for how the mobile phone should
 * behave. This phone can: Store, modify, and query contact names.
 * 
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 12, 2019
 */
public class MobilePhone {

	/**
	 * @return the myContacts
	 */
	public ArrayList<String> getMyContacts() {
		return myContacts;
	}

	/**
	 * This field holds the contact names in the phone
	 */
	private	ArrayList<String> myContacts = new ArrayList<String>();

	/**
	 * This method should add the contact to the arrayList
	 * 
	 * @param arrayList : The contact coming in
	 */
	public void addContact(ArrayList<String> arrayList) {
		myContacts.addAll(arrayList);
	}

	public void showContacts() {
		for (int i = 0; i < myContacts.size(); i++) {
			System.out.print((i + 1) + ". "+ myContacts.get(i) + "\n");
		}
	}
	
	public void modifyContact(String currentName, String newName, String newNumber) {
		int index = findItem(currentName);
		if (index >= 0) {
			modifyContact(index, newName, newNumber);
		}
	}
	
	public void modifyContact(int index, String newName, String newNumber) {
		myContacts.set(index, newName);
		myContacts.set(index + 1, newNumber);
	}
	
	public int findItem(String searchItem) {
		return myContacts.indexOf(searchItem);
	}
}
