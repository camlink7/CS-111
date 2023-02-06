

/*
 * Name: Camden Link
 * Assignment: Lab 5
 * Lab Instructor: Jakob Kaivo
 * Date: 2/06/2023
 * Purpose: This file contains the CheckingAccount implementation extending the base BankAccount class
 */

/*
 * Class Name: CheckingAccount
 * Purpose: This concrete class extends the BankAccount class and applies rules that are specific to the CheckingAccount bank account type
 * Exceptions: N/A
 */
public class CheckingAccount extends BankAccount {
	private final double INTEREST_RATE = 1.0001;
	
	/*
	 * Method Name: CheckingAccount
	 * Purpose: Constructs a new CheckingAccount object initialized with the given account name and initial balance
	 * Parameters:
	 * - name: The name associated with the bank account
	 * - amount: The default/initial balance of the bank account
	 * Preconditions: N/A
	 * Postconditions: A new CheckingAccount object is created an initialized with the name and default balance
	 * Exceptions: N/A
	 */
	public CheckingAccount(String name, double amount) {
		super(name, amount);
	}

	/*
	 * Method Name: accrueInterest
	 * Purpose: Add interest to the current account's balance based on the 0.01% interest rate for a CheckingAccount
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: The account's balance will be modified reflecting the accrued interest added to the current balance
	 * Exceptions: N/A
	 */
	public void accrueInterest() {
		this.balance *= INTEREST_RATE;
	}
}