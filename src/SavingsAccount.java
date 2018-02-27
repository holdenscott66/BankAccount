/**
 * SavingsAccount class is a subclass of the main class BankAccount
 * Able to access the public methods in the BankAccount class
 */

public class SavingsAccount extends BankAccount {
	//instance variables
	private double annualInterestRate;
	
	/**
	 * Default SavingsAccount constructor that takes no parameters and
	 * sets default values to the variables it uses
	 */
	public SavingsAccount() {
	}
	
	/**
	 * A SavingsAccount constructor
	 * @param c1				takes a parameter c1 which is an instance of the customer class
	 * @param newBalance		takes a parameter newBalance which sets the balance in the BankAccount class
	 */
	public SavingsAccount(Customer c1, double newBalance) {
		super.cust = new Customer(c1);
		super.setBalance(newBalance);
	}
	
	/**
	 * A SavingsAccount constructor that takes the balance and interest percentage
	 * @param newBalance		takes a parameter newBalance and sets the balance in the BankAccount class
	 * @param newInterest	takes a parameter newInterest and sets it as the annualInterestRate variable
	 */
	public SavingsAccount(double newBalance, double newInterest) {
		annualInterestRate = newInterest;
		super.setBalance(newBalance);
	}
	
	/**
	 * getAnnualInterestRate method returns the annualInterestRate that is set from the constructors
	 * @return annualInterestRate		returns the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/**
	 * setAnnualInterestRate takes a variable and sets the annualInterestRate instance variable to it
	 * @param newInterestRate	takes a paramater newInterestRate as a percentage
	 */
	public void setAnnualInterestRate(double newInterestRate) {
		if (newInterestRate >= 0 && newInterestRate < Double.POSITIVE_INFINITY)
			this.annualInterestRate = newInterestRate;
	}
	
	/**
	 * depositMonthlyInterest method returns the monthly interest based off of the annualInterestRate
	 * @return monthlyInterest		returns the amount of monthly interest from the current balance that is in
	 *										the BankAccount balance
	 */
	public void depositMonthlyInterest() {
	   double monthlyInterest =  (super.getBalance() * annualInterestRate / 100) / 12;
	   double balance = super.getBalance();
	   if (balance >= 0)
		   super.setBalance(balance + monthlyInterest);
	}
}
