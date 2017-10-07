/**
 * Account class for creation of a bank account with an id, balance and annual
 * interest rate. Accessor and mutator methods are available for these variables
 * and the date the account was created is stored. The interest rate and balance
 * are used to find the monthly interest earned. 
 * 
 * @author Ryan Schumacher
 */

import java.util.Date;

public class Account {

	// instance variables
	int accountId;
	double balance;
	double annualInterestRate;
	Date dateCreated;
	
	// default constructor
	public Account () {
		accountId = 0;
		balance = 0;
		annualInterestRate = 0;
	}

	// 3-argument constructor
	public Account (int pAccountId, double pBalance, double pAnnualInterestRate) {
		accountId = pAccountId;
		balance = pBalance;
		annualInterestRate = pAnnualInterestRate;
		dateCreated = new Date();		
	}
	
	// accessor methods
	public int getAccountId() {
		return accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterest() {
		return (this.getBalance() * ((this.getAnnualInterestRate()/100.00)) / 12.00);
	}
	
	// mutator methods
	public void setAccountId(int newId) {
		accountId = newId;
	}
	
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	public void setAnnualInterestRate(double newRate) {
		annualInterestRate = newRate;
	}
	
	public void withdraw(double withdrawal) {
		balance -= withdrawal;
	}
	
	public void deposit(int intDeposit) {
		balance += intDeposit;
	}
	
	public void deposit(double doubleDeposit) {
		balance += doubleDeposit;
	}

}
