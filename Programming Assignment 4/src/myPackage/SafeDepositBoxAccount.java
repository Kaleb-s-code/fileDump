package myPackage;
/*
 * SafeDepositBoxAccount.java
 */

/**
 * This class represents a safety deposit box in which the name
 * of the box owner is stored as a field. In addition, the class implements
 * the methods from the NamedAccount interface.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/5/2019
 */
public class SafeDepositBoxAccount implements NamedAccount{

	//	Field
	
	private String myNameOfOwner;

	//	Interface methods
	
	/**
	 * This is the interface's overridden method which acts as a 
	 * getter.
	 * 
	 * @return : This method returns the current name of the box owner.
	 */
	@Override
	public String getAccountHolderName() {
		return myNameOfOwner;
	}
	/**
	 * This method simply sets the account owner's name to the name
	 * passed through the parameter.
	 * 
	 * @param theNewName : This is the name of the safety deposit box owner.
	 */
	@Override
	public void setAccountHolderName(String theNewName) {
		myNameOfOwner = theNewName;
	}
	
	//	Constructor
	
	/**
	 * This is my constructor that sets the field to the parameter
	 * passed during instantiation.
	 * 
	 * @param theNameOfOwner : This is the name of the owner passed 
	 * during the creation of the object.
	 */
	public SafeDepositBoxAccount(String theNameOfOwner) {
		myNameOfOwner = theNameOfOwner;
	}
	
	/**
	 * This is the classe's toString method displays a simple
	 * presentation of the box owners name.
	 * 
	 * @return : This method returns the string representing
	 * the owner of the box.
	 */
	public String toString() {
		return (getClass().getSimpleName() + "[owner: " + myNameOfOwner + "]");
	}
}
