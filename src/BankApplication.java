import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * The BankApplication class represents the GUI that appears to the user
 * This BankApplication will be using the methods inside the classes in Customer, SavingsAccount 
 * and BankAccount
 * This class extends from the Application class that is provided by JavaFX
 */
public class BankApplication extends Application {
	
	
	Stage window;
	Scene scene1;

	
	Button executeButton;
	
	
	Customer c1 = new Customer("John", 314159);
	SavingsAccount s1 = new SavingsAccount(c1, 150.00);

	
	
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		

		/**
		 * creates a vertical box layout that contains the:
		 * Label CustomerNameLabel, customerIDLabel
		 * and changes the getID method to string to allow
		 * it to display on the customerIDLabel
		 */
		VBox layout1 = new VBox(15);
		
			Label customerNameLabel = new Label("Customer Name: " + c1.getName());
	
			String stringID = Integer.toString(c1.getID());
			Label customerIDLabel = new Label("Account ID #" + (stringID));
	

		/**
		 * creates a horizontal box layout that contains the:
		 * the textFields: depositTextField and withdrawTextField
		 *  and sets the textFields text to their respective fields
		 */
		HBox layout2 = new HBox(15);
		
			TextField depositTextField = new TextField();
			depositTextField.setPromptText("amt to deposit");
		
			TextField withdrawTextField = new TextField();
			withdrawTextField.setPromptText("amt to withdraw");
		
			
		
		
		/**
		 * creates a vertical box that contains the:
		 * balanceLabel, the executeButton
		 * The execute button allows the user to input the amount they wish to
		 * withdraw or deposit
		 * It also contains a try/catch to check if the user inputs an invalid input
		 * (ex. letters, letters mixed with numbers, etc)
		 */
		VBox layout3 = new VBox(15);
		
			Label balanceLabel = new Label("Current Balance $" + s1.getBalance());
			
			
			executeButton = new Button();
			executeButton.setText("Execute");
			
			executeButton.setOnAction(e -> {
				try { 
	                if (withdrawTextField.getText().isEmpty() && depositTextField.getText().isEmpty()) {

	                }
	                else if (withdrawTextField.getText().isEmpty()) {
	                    double deposit = Double.parseDouble(depositTextField.getText()); 
	                    s1.deposit(deposit);
	                    balanceLabel.setText("Current Balance $" + s1.getBalance());
	                    depositTextField.clear();
	                }

	                else if (depositTextField.getText().isEmpty()) {
	                    double withdraw = Double.parseDouble(withdrawTextField.getText()); 
	                    s1.withdraw(withdraw);
	                    balanceLabel.setText("Current Balance $" + s1.getBalance());
	                    withdrawTextField.clear();
	                }
	                else {
	                    double withdraw = Double.parseDouble(withdrawTextField.getText()); 
	                    double deposit = Double.parseDouble(depositTextField.getText()); 
	                    s1.withdraw(withdraw);
	                    s1.deposit(deposit);
	                    balanceLabel.setText("Current Balance $" + s1.getBalance());
	                    depositTextField.clear();
	                    withdrawTextField.clear();
	                    }
	            }
			catch(Exception a) 
			{
				depositTextField.clear();
				withdrawTextField.clear();
	
			}
		});

		/**
		 * adds the layouts to the GUI screen. 
		 * layout 2 and 3 are part of layout 1 to allow
		 * them to display in a VBox layout
		 */
		layout3.getChildren().addAll(executeButton, balanceLabel);
		layout2.getChildren().addAll(depositTextField, withdrawTextField);
		layout1.getChildren().addAll(customerNameLabel, customerIDLabel, layout2, layout3);
		
		
		scene1 = new Scene(layout1, 400,400);	
		window.setTitle("Bank Application");
		window.setScene(scene1);
		window.show();
	}
}
