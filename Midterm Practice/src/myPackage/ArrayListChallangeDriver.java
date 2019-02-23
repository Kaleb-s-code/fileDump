/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.Scanner;

/**
 * This class is the driver for the mobile phone where a menu is used
 * to control the various functions within the phone.
 *
 * @author : Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 12, 2019
 */
public class ArrayListChallangeDriver {

	/**
	 * This is for reading input
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * This is the mobile phone instantiation
	 */
	private static MobilePhone mobilePhone = new MobilePhone();

	/**
	 * These are the contacts
	 */
	private static Contacts contacts = new Contacts();
	/**
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		boolean quit = false;
		int choice = 0;
		getInstructions();

		while (!quit) {
			System.out.println("\nSelect an option from the menu: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 0:
				getInstructions();
				break;
			case 1:
				saveContact();
				break;
			case 2:
				modifyContact();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				queryContact();
				break;
			case 5:
				mobilePhone.showContacts();
				break;
			case 6:
				quit = true;
				break;
			}
		}
	}

	/**
	 * This method prints the instructions to the user of the mobile phone
	 */
	public static void getInstructions() {
		System.out.println("\nPress");
		System.out.println("\t 0 - To get instructions.");
		System.out.println("\t 1 - To save a contact.");
		System.out.println("\t 2 - To modify a contact.");
		System.out.println("\t 3 - To remove a contact.");
		System.out.println("\t 4 - To search for a contact.");
		System.out.println("\t 5 - To show contacts.");
		System.out.println("\t 5 - To quit.");
	}

	/**
	 * This method saves the contact 
	 */
	public static void saveContact() {
		System.out.print("Enter a contact name: ");
		contacts.addContact(scanner.nextLine());
//		System.out.print("Enter a contact Number: ");
//		contacts.addContact(scanner.nextLine());
//This adds everything to the mobile contact?
		mobilePhone.addContact(contacts.getMyContact());
		System.out.println("**Contact added successfully.**");
		
	}
	
	/**
	 * 
	 */
	public static void modifyContact() {
		System.out.print("Enter the name you would like to update: ");
		String indexNumber = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Enter a new name: ");
		String newName = scanner.nextLine();
		System.out.print("Enter a new number: ");
		String newNumber = scanner.nextLine();
		mobilePhone.modifyContact(indexNumber, newName, newNumber);
		System.out.println("**Contact updated successfully.**");
	}
	
	/**
	 * 
	 */
	public static void removeContact() {
		
	}
	
	/**
	 * 
	 */
	public static void queryContact() {
		
	}
}
