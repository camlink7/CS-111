package Lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {
	private final double SAVINGS_WITHDRAWAL_FEE = 5.00;
	private final double SAVINGS_INTEREST = 1.0010;
	private final double CHECKING_INTEREST = 1.0001;
	
	@Test
	void testSetName() {
		String saver = "Steve Saver";
		String checker = "Charlie Checker";
		BankAccount sa = new SavingsAccount("Savvy Saver", 0.00);
		BankAccount ca = new CheckingAccount("Chubby Checker", 0.00);
		sa.setName(saver);
		ca.setName(checker);
		assertEquals(saver, sa.getName());
		assertEquals(checker, ca.getName());
	}

	@Test
	void testGetName() {
		String saver = "Savvy Saver";
		String checker = "Chubby Checker";
		BankAccount sa = new SavingsAccount(saver, 0.00);
		BankAccount ca = new CheckingAccount(checker, 0.00);
		assertEquals(saver, sa.getName());
		assertEquals(checker, ca.getName());
	}

	@Test
	void testDeposit() {
		double base = 25.00;
		double deposit = 50.00;
		double total = base + deposit;
		BankAccount sa = new SavingsAccount("Savvy Saver", base);
		BankAccount ca = new CheckingAccount("Chubby Checker", base);
		sa.deposit(deposit);
		ca.deposit(deposit);
		assertEquals(total, sa.getBalance());
		assertEquals(total, ca.getBalance());
	}

	@Test
	void testWithdraw() {
		double base = 25.00;
		double withdraw = 5.00;
		double savingsBalance = base - withdraw - SAVINGS_WITHDRAWAL_FEE;
		double checkingBalance = base - withdraw;
		BankAccount sa = new SavingsAccount("Savvy Saver", base);
		BankAccount ca = new CheckingAccount("Chubby Checker", base);
		sa.withdraw(withdraw);
		ca.withdraw(withdraw);
		assertEquals(savingsBalance, sa.getBalance());
		assertEquals(checkingBalance, ca.getBalance());
	}

	@Test
	void testGetBalance() {
		double base = 25.00;
		BankAccount sa = new SavingsAccount("Savvy Saver", base);
		BankAccount ca = new CheckingAccount("Chubby Checker", base);
		assertEquals(base, sa.getBalance());
		assertEquals(base, ca.getBalance());
	}

	@Test
	void testAccrueInterest() {
		double base = 10000.00;
		double savingsBalance = base * SAVINGS_INTEREST;
		double checkingBalance = base * CHECKING_INTEREST;
		BankAccount sa = new SavingsAccount("Savvy Saver", base);
		BankAccount ca = new CheckingAccount("Chubby Checker", base);
		sa.accrueInterest();
		ca.accrueInterest();
		assertEquals(savingsBalance, sa.getBalance());
		assertEquals(checkingBalance, ca.getBalance());
	}

}