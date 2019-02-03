package myPackage;
/*
 * SavingsAccount.java
 */

/**
 * This class represents a savings account in which deposits can 
 * be made, and withdrawals can be processed. This class 
 * inherits the fields and methods of the superclass BankAccount,
 * as it performs in the same way as an account should. 
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 2/5/2019
 *
 */
public class SavingsAccount extends BankAccount {

//	Fields
	private boolean myStatusIsActive;

//	Constructor
	/**
	 * This is my constructor in which the name of the owner and the interest rate are
	 * sent to the super class inherited fields. This method also performs a basic 
	 * check for account status.   
	 * 
	 * @param theNameOfOwner : This is the name of the owner of the account.
	 * @param theInterestRate : This is the interest rate passed upon creation.
	 */
	
	public SavingsAccount(String theNameOfOwner, double theInterestRate) {
		super(theNameOfOwner, theInterestRate);
		if (super.getBalance() >= 25.00) {
			myStatusIsActive = true;
		} else {
			myStatusIsActive = false;
		}
	}
	
//	Methods
/**
 * This method performs in a similar way to the super classe's method.
 * The only difference is that it is checking for account status.
 * 
 * @param theAmount : This is the amount to be deposited.
 * @return : This method returns a boolean indicating
 * whether or not the deposit was successful.
 */
	public boolean processDeposit(final double theAmount) {
		boolean returnValue = false;
		if(super.processDeposit(theAmount)) {
			if (super.getBalance() >= 25.00) {
				myStatusIsActive = true;
				returnValue = true;
			}
		}		
		return returnValue;
	}
	
/**
 * This method performs is basically the same way as the parallel method
 * in the super class, but it performs an additional check, and 
 * sets the account status based on test.
 * 
 * @param theAmount : This parameter is the amount passed 
 * for withdrawal. 
 * @return : This method returns a boolean indicating
 * whether or not the withdrawal was processed.
 */
	public boolean processWithdrawal(final double theAmount) {
		boolean returnValue = false;
		if (myStatusIsActive == true) {
			returnValue = true;
			super.processWithdrawal(theAmount);
			if (super.getBalance() < 25.00) {
				myStatusIsActive = false;
			}
		}
//		Checking for monthly service charges
		if(super.myMonthlyWithdrawCount > 5) {
			super.myMonthlyServiceCharges += 1.00;
		}
		return returnValue;
	}
	
/**
 * This method calls the identical method in the superclass then
 * performs a simple check which influences the status of the account.
 */
	public void performMonthlyProcess() {
		super.performMonthlyProcess();
		if (super.getBalance() >= 25.00) {
			myStatusIsActive = true;
		} else {
			myStatusIsActive = false;
		}
	}
	
	/**
	 * This method is my toString that calls the superclass' toString
	 * for output.
	 * 
	 * @return : This method returns the superclass' formatted toString method
	 */
	public String toString() {
		return super.toString(myStatusIsActive);
	}
}
