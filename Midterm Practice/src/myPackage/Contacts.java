/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;

/**
 * This class holds the logic for the contacts in the phone
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 12, 2019
 */
public class Contacts {

	/**
	 * This is the contact name
	 */
	private ArrayList<String> myContact = new ArrayList<String>();

	
	/**
	 * This method actually does the adding 
	 * 
	 * @param contact
	 */
	public void addContact(String theContact) {
		myContact.add(theContact);
		System.out.println(theContact);
		System.out.println(myContact);
	}

	/**
	 * @return the myContact
	 */
	public ArrayList<String> getMyContact() {
		return myContact;
	}

	
	
	
}
