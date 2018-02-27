/**
 * The Customer class represents a customer that has a name and an id
 * This customer will be using the bank account created in the bank account class
 * This class allows for changing of names and id's and has methods that allow 
 * for the name and id to be displayed as a string
 */

public class Customer{
	//variables 
	String name;
	int customerID;
	/** 
	 * constructor method creates a customer with default values
	 */
	public Customer(){
		name = "";
		customerID = 0;
	}
	
	/**
	 * The Customer constructor method creates a customer with a name and an ID
	 * @param newName		is the new name for the customer
	 * @param newID			is the ID for the customer
	 */
	
	public Customer(String newName, int newID){
		name = newName;
		customerID = newID;
	}
	
	/**
	 * The Customer method is used to create a customer that is exactly like c1
	 * @param c1 		is the customer c1 that is used to create a customer
	 * 					identical to the c1 customer
	 */
	
	public Customer(Customer c1){
		name = c1.getName();
		customerID = c1.getID();
	}
	
	/**
	 * The setName method allows for a customer to change their name 
	 * 
	 * @param newName		is the new name being used in the method to 
	 * 						replace the old name
	 */
	
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * The setID method allows for a customer to change their ID
	 * 
	 * @param newid			is the new ID being used in the method to
	 * 						replace the old ID
	 */
	
	public void setID(int newid){
		customerID = newid;
		
	}
	
	/**
	 * The getName method is used to call on the current name
	 * @return the name of the customer currently
	 */
	
	public String getName(){
		return name;
	}
	
	/**
	 * The getID method is used to call on the current I
	 * @return the id of the customer currently
	 */
	
	public int getID(){
		return customerID;
	}
	
	/**
	 * The toString method is used to convert the name and the ID of the customer
	 * into a string
	 * @return the name and ID as a string 
	 */
	
	public String toString(){
			return "Name: " + name + ", ID: " + customerID;
	}
	
	
}
