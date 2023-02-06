

/*
 * Name: Camden Link
 * Assignment: Lab 5
 * Lab Instructor: Jakob Kaivo
 * Date: 2/06/2023
 * Purpose: This file contains the abstract class BankAccount, which is the parent to specific implementations of a BankAccount
 */

/*
 * Class Name: BankAccount
 * Purpose: This abstract class provides shared functionality for a BankAccount at the bank, but does not specify a certain type
 * of bank account
 * Exceptions: N/A
 */
public abstract class BankAccount {
	private String name;
	protected double balance;
	
	/*
	 * Method Name: BankAccount
	 * Purpose: Constructs a new BankAccount object. Since the class is abstract, this constructor will likely be called
	 * from a child concrete class of BankAccount
	 * Parameters:
	 * - accountName: The name associated with the bank account
	 * - initialBalance: The default/starting balance of the bank account
	 * Preconditions: N/A
	 * Postconditions: A new BankAccount object will be constructed from a child, concrete implementation of BankAccount
	 * Exceptions: N/A
	 */
	public BankAccount (String accountName, double initialBalance) {
		this.setName(accountName);
		this.balance = initialBalance;
	}
	/*
	 * Method Name: setName
	 * Purpose: Sets the name of the bank account to the given new name
	 * Parameters:
	 * - name: The new name of the bank account
	 * Preconditions: N/A
	 * Postconditions: The BankAccount object's name will be modified and set equal to the given new name
	 * Exceptions: N/A
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Method Name: getName
	 * Purpose: Gets the name associated with the bank account
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a String that is the name associated with the bank account
	 * Exceptions: N/A
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * Method Name: getBalance
	 * Purpose: Gets the current balance of the bank account
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a double which is the current balance stored in the bank account
	 * Exceptions: N/A
	 */
	public double getBalance() {
		return this.balance;
	}

	/*
	 * Method Name: deposit
	 * Purpose: Adds a given amount to the current balance of the bank account (deposits)
	 * Parameters:
	 * - amount: The amount to be added/deposited into the bank account
	 * Preconditions: Ideally, amount should be a positive number
	 * Postconditions: The current bank account's balance will be modified with the given amount added to it
	 * Exceptions: N/A
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/*
	 * Method Name: withdraw
	 * Purpose: Withdraws a given amount of money from the bank account
	 * Parameters:
	 * - amount: The base amount to be taken from the account balance
	 * Preconditions: N/A
	 * Postconditions: The bank account's balance will have the amount subtracted
	 * Exceptions: N/A
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/*
	 * Method Name: accrueInterest
	 * Purpose: Abstract header for adding interest to the current bank account's balance
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: The bank account's balance may be changed depending on the interest accrued
	 * Exceptions: N/A
	 */
	public abstract void accrueInterest();
}