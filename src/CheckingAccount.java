/**
 * CheckingAccount class extends the Account class to provide different functionality
 * for the withdraw method.
 * 
 * @author Ryan Schumacher
 */

public class CheckingAccount extends Account {

	// call to superclass default constructor
	public CheckingAccount() {
		super();
	}

	// call to superclass 3-argument constructor
	public CheckingAccount (int pAccountId, double pBalance, double pAnnualInterestRate) {
		super(pAccountId, pBalance, pAnnualInterestRate);		
	}	
	
	// overridden withdraw method
	public void withdraw(double withdrawal) {
		if((balance-withdrawal) > -5000) {
			balance -= withdrawal;
		} else {
			System.out.println("overdraft limit prevents withdrawing more than " + (balance+5000));
			System.out.println();
		}
	}
	
}
