package myPackage;
/*
 * This interface was written in the assignment sheet. 
 * for programming project 4.
 */

/**
 * This is the interface which indicates the methods that
 * should be included in whichever class implements this 
 * interface.
 * 
 * @author TCSS 143
 * @version unknown
 *
 */
public interface NamedAccount {
	String getAccountHolderName();
	void setAccountHolderName(final String theNewName);
}
