/*
 * Multiline comment at the top of the document
 */
package myPackage;

import java.util.ArrayList;

/**
 * This class does things and stuff that a class should do And there
 * are more things that it can do too.
 *
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version : Feb 12, 2019
 */
public class ArrayListPracticeGroceryList {

	/**
	 * Javaodc
	 */
	private ArrayList<String> groceryList = new ArrayList<String>();

	/**
	 * This adds an item to the list
	 * 
	 * @param item : item in the grocery list
	 */
	public void addGroceryItem(String item) {
		groceryList.add(item);
	}

	/**
	 * This is a getter for the arrayList
	 * 
	 * @return the groceryList
	 */
	public ArrayList<String> getGroceryList() {
		return groceryList;
	}

	/**
	 * This prints the list out
	 */
	public void printGroceryList() {
		System.out.println("You have " + groceryList.size() + " items in your list");
		for (int i = 0; i < groceryList.size(); i++) {
			System.out.println((i + 1) + ". " + groceryList.get(i));
		}
	}

	/**
	 * This modifies the position of an item in the list
	 * 
	 * @param position : location of item to be
	 * @param newItem  : the new item
	 */
	private void modifyGroceryItem(int position, String newItem) {
		groceryList.set(position, newItem);
		System.out.println("Grocery item : " + (position + 1) + " has been " + " modified.");
	}

	/**
	 * Overloaded modify grocery method
	 */
	public void modifyGroceryItem(String currentItem, String newItem) {
		int position = findItem(currentItem);
		if (position >= 0) {
			modifyGroceryItem(position, newItem);
		}
	}

	/**
	 * This removes an item from the list
	 * 
	 * @param position : the position to be removed
	 */
	private void removeItem(int position) {
		groceryList.remove(position);
	}

	/**
	 * Overloaded method for removing an item
	 * 
	 * @param item : the item to be removed
	 */
	public void removeItem(String item) {
		int position = findItem(item);
		if (position >= 0) {
			removeItem(position);
		}
	}

	/**
	 * This finds an item
	 * 
	 * @param searchItem : the item to be searched
	 * @return : returns the item
	 */
	private int findItem(String searchItem) {
		return groceryList.indexOf(searchItem);
	}

	/**
	 * This checks if an item is in the list
	 * 
	 * @param searchItem : The item to be searched for
	 * @return : a boolean indicating a found or not found item.
	 */
	public boolean onFile(String searchItem) {
		boolean result = false;
		int position = findItem(searchItem);
		if (position >= 0) {
			result = true;
		}
		return result;
	}

}
