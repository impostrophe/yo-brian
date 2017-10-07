import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		
		// variables for account creation
		int id1;
		double balance1;
		double rate1;
	
		int id2;
		double balance2;
		double rate2;

		double checkingWithdraw;
		double checkingDeposit;
		
		double savingsWithdraw;
		double savingsDeposit;
		
		
		Scanner in = new Scanner(System.in);
		
		// get user input for creation of savings and checking accounts
		System.out.println("enter savings account id");		
		id1 = in.nextInt();
		System.out.println("enter savings account balance");
		balance1 = in.nextDouble();
		System.out.println("enter savings account annual interest rate");
		rate1 = in.nextDouble();
		
		System.out.println("enter checking account id");		
		id2 = in.nextInt();
		System.out.println("enter checking account balance");
		balance2 = in.nextDouble();
		System.out.println("enter checking account annual interest rate");
		rate2 = in.nextDouble();
		
		// create savings and checking accounts based on input
		SavingsAccount testAccount1 = new SavingsAccount(id1, balance1, rate1);
		CheckingAccount testAccount2 = new CheckingAccount(id2, balance2, rate2);

		// test overdraft restrictions on overridden withdraw methods and make deposits
		System.out.println("amount to withdraw from savings");
		checkingWithdraw = in.nextDouble();
		testAccount1.withdraw(checkingWithdraw);
		
		System.out.println("amount to deposit to savings");
		checkingDeposit = in.nextDouble();
		testAccount1.deposit(checkingDeposit);
		
		System.out.println("amount to withdraw from checking");
		savingsWithdraw = in.nextDouble();
		testAccount2.withdraw(savingsWithdraw);
		
		System.out.println("amount to deposit to checking");
		savingsDeposit = in.nextDouble();
		testAccount2.deposit(savingsDeposit);
		
		// print information for checking and savings accounts
		System.out.println();
		System.out.println("savings id:" + "\t" + testAccount1.getAccountId());
		System.out.print("balance:" + "\t");
		System.out.printf("$%2.2f", testAccount1.getBalance());
		System.out.println();
		System.out.print("interest:" + "\t");
		System.out.printf("$%2.2f", testAccount1.getMonthlyInterest());
		System.out.println();
		System.out.println("date created:" + "\t" + testAccount1.getDateCreated());
		
		System.out.println("checking id:" + "\t" + testAccount2.getAccountId());
		System.out.print("balance:" + "\t");
		System.out.printf("$%2.2f", testAccount2.getBalance());
		System.out.println();
		System.out.print("interest:" + "\t");
		System.out.printf("$%2.2f", testAccount2.getMonthlyInterest());
		System.out.println();
		System.out.println("date created:" + "\t" + testAccount2.getDateCreated());

	}
}