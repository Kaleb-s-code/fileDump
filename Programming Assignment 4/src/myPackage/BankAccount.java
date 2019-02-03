package myPackage;
/*
 * BankAccount.java
 * 
 * 
 * AWWWWWWWWWWWWWWWWWWWWWWWW!!!!!!!!!!!!!!
 */

/**
 * This class performs as a basic bank account should. It accepts deposits 
 * and withdrawals and records the name and interest rates associated 
 * with the account. In addition, it keeps track of the monthly service 
 * charges, and the total withdrawal in a simulated month.
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/5/2019
 *
 */
public class BankAccount implements NamedAccount{
//	Fields
	private String myCustomersName;
	private double myAccountBalance;
	private double myInterestRate;
	protected int myMonthlyWithdrawCount;
	protected double myMonthlyServiceCharges;
	
//	Interface methods
	/**
	 * This is the interface's overridden method which acts as a 
	 * getter.
	 * 
	 * @return : This method returns the current name of the box owner.
	 */
	@Override
	public String getAccountHolderName() {
		return myCustomersName;
	}
	
	/**
	 * This method simply sets the account owner's name to the name
	 * passed through the parameter.
	 * 
	 * @param theNewName: This is the name of the safety deposit box owner.
	 */
	@Override
	public void setAccountHolderName(String theNewName) {
		myCustomersName = theNewName;
	}
	
//	Constructor
	/**
	 * This is my constructor that sets the fields of this superclass to the passed values at the 
	 * time of creation.
	 * 
	 * @param theNameOfOwner : This is the name of the owner of the bank account.
	 * @param theInterestRate : This is the interest rate that is passed and 
	 * checked by the method.
	 */
	public BankAccount(final String theNameOfOwner, final double theInterestRate) {
		myCustomersName = theNameOfOwner;
		if (theInterestRate >= 0.00) {
			myInterestRate = theInterestRate;
		} else {
			myInterestRate = 0.00;
		}
	}
	
//	Methods
	/**
	 * This method is a getter for the field of this superclass myAccountBalance.
	 * 
	 * @return : This returns the current value of the field myAccountBalance.
	 */
	public double getBalance() {
		return myAccountBalance;
	}
	/**
	 * This method processes a deposit and ensures that it's a proper value.
	 * 
	 * @param theAmount : This is the amount of money to be deposited passed.
	 * @return : This method returns whether or not the deposit was processed.
	 */
	public boolean processDeposit(final double theAmount) {
		boolean returnValue = false;
		 if(theAmount > 0.00) {
			 myAccountBalance += theAmount;
			 returnValue = true;
		 }
		return returnValue;
	}
	
	/**
	 * This method processes withdrawals and ensures that they meet a basic 
	 * criteria. If successful, the amount passed is removed from the associated
	 * field.
	 * 
	 * @param theAmount : This is the amount to be withdrawn passed.
	 * @return : This method returns whether or not the withdrawal was successful.
	 */
	public boolean processWithdrawal(final double theAmount) {
		boolean returnValue = false;
		if (theAmount >= 0.00 && theAmount <= myAccountBalance) {
			myAccountBalance -= theAmount;
			myMonthlyWithdrawCount += 1; 
			returnValue = true;
		}
		return returnValue;
	}
	
	/**
	 * This method simply calculates the interest.
	 * 
	 * @return : This method returns the calculated interest.
	 */
	public double calculateInterest() {
		return myAccountBalance * (myInterestRate / 12.0);
	}
	
	/**
	 * This method performs a monthly process of removing the monthly service charges 
	 * first from the balance, then pays interest on the remaining amount. Following this, 
	 * the the withdrawal and service charge fields are reset. 
	 * 
	 */
	public void performMonthlyProcess() {
		myAccountBalance -= myMonthlyServiceCharges;
//		If improper value, sets balance to 0
		if (myAccountBalance < 0.00) {
			myAccountBalance = 0.00;
		}
		myAccountBalance += calculateInterest();
	//reseting fields
		myMonthlyWithdrawCount = 0;
		myMonthlyServiceCharges = 0;
	}
	
	/**
	 * This is my toString() method in which the proper fields are placed inside 
	 * of a formatted string.
	 * 
	 * @return : This method returns the formatted string. 
	 */
	public String toString() {
	
		return String.format("%s[owner: %s, balance: %.2f, interest rate: %.2f"
				+ ", number of withdrawals this month: %d"
				+ ", service charges this month: %.2f]"
				, getClass().getSimpleName(), myCustomersName, myAccountBalance, myInterestRate
				, myMonthlyWithdrawCount, myMonthlyServiceCharges);
	}

//Overloaded toString() method 
	/**
	 * This is the overloaded toString method that is used instead of the one above 
	 * to accommodate the boolean parameter.
	 * 
	 * @param myStatusIsActive : This is the parameter that indicated
	 * whether or not the account is active. 
	 * @return : This returns the same string as the other method
	 * but instead includes the myStatusIsActive portion.
	 */
	public String toString(boolean myStatusIsActive) {
		
		return String.format("%s[owner: %s, balance: %.2f, interest rate: %.2f"
				+ ", number of withdrawals this month: %d"
				+ ", service charges this month: %.2f," + " myStatusIsActive: %s]"
				, getClass().getSimpleName(), myCustomersName, myAccountBalance, myInterestRate
				, myMonthlyWithdrawCount, myMonthlyServiceCharges, myStatusIsActive);
	}
}
