

/*
 * Name: Camden Link
 * Assignment: Lab 5
 * Lab Instructor: Jakob Kaivo
 * Date: 2/06/2023
 * Purpose: This file contains the SavingsAccount implementation extending the base BankAccount class
 */

/*
 * Class Name: SavingsAccount
 * Purpose: This concrete class implementation of BankAccount has the common functionality of a BankAccount while also
 * applying rules specific to a SavingsAccount
 * Exceptions: N/A
 */
public class SavingsAccount extends BankAccount {
	private final double INTEREST_RATE = 1.0010;
	
	/*
	 * Method Name: SavingsAccount
	 * Purpose: Constructs a new SavingsAccount object which extends the BankAccount class
	 * Parameters:
	 * - name: The name associated with the bank account
	 * - amount: The default/initial balance of the bank account
	 * Preconditions: N/A
	 * Postconditions: A new SavingsAccount object is created an initialized with the name and default balance
	 * Exceptions: N/A
	 */
	public SavingsAccount(String name, double amount) {
		super(name, amount);
	}

	/*
	 * Method Name: withdraw
	 * Purpose: Withdraws the given amount from the bank account balance AND taking a $5.00 transaction fee on top
	 * of the initial withdraw. This method OVERRIDES the BankAccount withdraw method
	 * Parameters:
	 * - amount: The double amount to be withdrew from the savings account
	 * Preconditions: Ideally, amount should be a positive double
	 * Postconditions: The SavingsAccount object's balance will be modified after the withdraw and transaction fee are taken from 
	 * the balance
	 * Exceptions: N/A
	 */
	@Override
	public void withdraw(double amount) {
		this.balance -= (amount + 5.00);
	}

	/*
	 * Method Name: accrueInterest
	 * Purpose: Add interest to the current account's balance based on the 0.10% interest rate for a SavingsAccount
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: The account's balance will be modified reflecting the accrued interest added to the current balance
	 * Exceptions: N/A
	 */
	public void accrueInterest() {
		this.balance *= INTEREST_RATE;
	}
}