/**
 * SavingsAccount class extends the Account class to provide different functionality
 * for the withdraw method.
 * 
 * @author Ryan Schumacher
 */

public class SavingsAccount extends Account {

	// call to default constructor	
	public SavingsAccount() {
		super();
	}

	// call to superclass 3-argument constructor
	public SavingsAccount (int pAccountId, double pBalance, double pAnnualInterestRate) {
		super(pAccountId, pBalance, pAnnualInterestRate);		
	}	

	// overridden withdraw method	
	public void withdraw(double withdrawal) {
		if((balance-withdrawal) > 0) {
			balance -= withdrawal;
		} else {
			System.out.println("overdraft limit prevents withdrawing more than " + (balance));
			System.out.println();
		}
	}
	
}
