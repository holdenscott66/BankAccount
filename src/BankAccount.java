/**
 * The BankAccount class represents a bank account that can take
 * information from the Customer class that includes details on 
 * the customer like their name and ID
 * The bank account includes a balance for the customer's funds,
 * the ability to deposit, withdraw, view balance, and set an 
 * amount for the overdaft limits 
 */

public class BankAccount {
	
	/**
	 * Private instance variables balance and overdraftAmount
	 * Instance of the Customer class cust
	 */
	
	private double balance;
	private double overdraftAmount;
	Customer cust;
	
	/**
	 * Default BankAccount constructor method which sets the balance, overdraftAmount, 
	 * and Customer instance
	 */
	public BankAccount() {
		balance = 0.0;
		overdraftAmount = 100.0;
		cust = new Customer();
	}
	
	/**
	 * BankAccount constructor which takes the initialBalance as type double
	 * @param initialBalance	is the initial balance in the bank account
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
		overdraftAmount = 100.0;
		cust = new Customer();
	}
	
	/**
	 * BankAccount constructor which takes a customer and a balance
	 * @param newCustomer	customer who the bank account is for
	 * @param newBalance		new balance that the customer has in their account
	 */
	public BankAccount(Customer newCustomer, double newBalance) {
		cust = newCustomer;
		balance = newBalance;
		overdraftAmount = 100.0;
	}
	
	/**
   * The method getBalance is used to determine the current balance in the account
   * The user will be able to call on this method to see how much they have in their
   * bank account
   * 
   * @return balance to see how much money is within the account
   */
	public double getBalance() {
		return balance;
	}
	
	/**
   * This method creates a customer that is detailed in the Customer class
   * @return the customer cust created in the Customer class
   */
	public Customer getCustomer() {
		return new Customer(cust);
	}
	
	/**
   * The setOverdraftAmount method is used to set the overdraft amount within the account
   * This will set the account up to only allow withdrawals that do not exceed the over
   * draft amount
   * @param newAmount		is the amount as a positive number that indicates how much money can 
   * 							be withdrawn below zero before the bank account disallows any more
   * 							withdrawals
   */
	public void setOverdraftAmount(double newAmount) {
		if((-1*newAmount)<=balance) {
			this.overdraftAmount = newAmount;
		}
	}
	
	/**
	 * The setBalance method is used to set the balance of the bank account
	 * @param newBalance		is the amount that is set as the balance for the class
	 */
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	
	/**
   * The deposit method allows for the depositing of amounts into the bank
   * account
   * There is a check to make sure the amount being deposited is at least 0
   * or more
   * If the deposit passes the check, then the balance is updated to reflect
   * the addition of the previous balance and the deposited amount
   * 
   * @param newDeposit		is the amount being deposited
   */
	public void deposit(double newDeposit) {
		if (newDeposit >=0 && newDeposit < Double.POSITIVE_INFINITY) {
			balance = balance + newDeposit;
		}
	}
	
	/**
       * The withdraw method allows for a withdrawal from the account
       * This withdrawal would subtract the withdrawal amount from the balance in the account
       * A check is run to make sure the withdrawal amount follows the rules set by the 
       * overdraft amount
       * 
       * @param newWithdraw		is the amount that is being entered to be withdrawn from the bank 
       * 								account
       * 								As long as it does not exceed the overdraft amount set on the accout
       * 								this amount will be withdrawn
       */
	public void withdraw(double newWithdraw) {
		if ((balance - newWithdraw >= -1*overdraftAmount) && newWithdraw > Double.NEGATIVE_INFINITY){
			balance = balance - newWithdraw;
		}
	}
}
