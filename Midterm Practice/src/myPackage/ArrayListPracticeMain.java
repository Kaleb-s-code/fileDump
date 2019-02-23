/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class does things and stuff that a class should do And there
 * are more things that it can do too.
 *
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 12, 2019
 */
public class ArrayListPracticeMain {
	/**
	 * Scanner field instantiation
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * This is a grocery list instantiation
	 */
	private static ArrayListPracticeGroceryList groceryList = new ArrayListPracticeGroceryList();

	/**
	 * This program is the driver for a grocery list app where you can
	 * add, delete modify and search for items in a grocery list.
	 * 
	 * @param theArgs
	 */
	public static void main(String[] theArgs) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while (!quit) {
			System.out.println("Enter your menu item choice: ");
			choice = scanner.nextInt();
			// Clearing input buffer?
			scanner.nextLine();

			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				groceryList.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				processArrayList();
				break;
			case 7:
				quit = true;
				break;
			}
		}
	}

	/**
	 * This prints the instructions
	 */
	public static void printInstructions() {
		System.out.println("\nPress");
		System.out.println("\t 0 - To Print choice options.");
		System.out.println("\t 1 - To Print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To modify an item in the list.");
		System.out.println("\t 4 - To remove an item from the list.");
		System.out.println("\t 5 - To search for an item in the list.");
		System.out.println("\t 6 - To quit the application.");
	}

	/**
	 * This is a method that adds the item
	 */
	public static void addItem() {
		System.out.print("Please enter the grocery item: ");
		groceryList.addGroceryItem(scanner.nextLine());
	}

	/**
	 * This method modifies the item
	 */
	public static void modifyItem() {
		System.out.print("Current item name: ");
		String itemNumber = scanner.nextLine();
		System.out.println("Enter new item: ");
		String newItem = scanner.nextLine();
		groceryList.modifyGroceryItem(itemNumber, newItem);
	}

	/**
	 * This method removes items
	 */
	public static void removeItem() {
		System.out.println("Enter item name: ");
		String itemNumber = scanner.nextLine();
		groceryList.removeItem(itemNumber);
	}

	/**
	 * This searches for an item
	 */
	public static void searchForItem() {
		System.out.println("Enter item to search for: ");
		String searchItem = scanner.nextLine();
		if (groceryList.onFile(searchItem)) {
			System.out.println(searchItem + ": Found.");
		} else {
			System.out.println(searchItem + ": NOT found.");
		}
	}

	/**
	 * This method contains a few ways to mess with arrayLists
	 */
	public static void processArrayList() {

		/*
		 * This piece of code copies the arrayList field from the class via
		 * the getter, so that you can process it without changing the actual
		 * list.
		 */
		ArrayList<String> newArray = new ArrayList<String>();
		newArray.addAll(groceryList.getGroceryList());

		/*
		 * This one line does the same thing as the two lines above, it just
		 * combines it all into one (SHORT CUT)
		 */
		ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

		/*
		 * This is how you convert an ArrayList to a simple array
		 */
		String[] myArray = new String[groceryList.getGroceryList().size()];
		myArray = groceryList.getGroceryList().toArray(myArray);
	}
}
