import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BankApplication extends Application {
	
	// NOT DONE COMMENTING YET, WILL DO IT NEXT WEEK 
	
	
	//declaring the stage and scene
	Stage window;
	Scene scene1;

	//declaring the execute button
	Button executeButton;
	
	//declare the customer and the savings account amount
	Customer c1 = new Customer("John", 314159);
	SavingsAccount s1 = new SavingsAccount(c1, 150.00);

	
	
	
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		

		VBox layout1 = new VBox(15);
		
			Label customerNameLabel = new Label("Customer Name: " + c1.getName());
	
			String stringID = Integer.toString(c1.getID());
			Label customerIDLabel = new Label("Account ID #" + (stringID));
	

	
		//horizontal placements for the text boxes
		HBox layout2 = new HBox(15);
		
			TextField depositTextField = new TextField();
			depositTextField.setPromptText("amt to deposit");
		
			TextField withdrawTextField = new TextField();
			withdrawTextField.setPromptText("amt to withdraw");
		
			
		VBox layout3 = new VBox(15);
		
			Label balanceLabel = new Label("Current Balance $" + s1.getBalance());
			
			
			executeButton = new Button();
			executeButton.setText("Execute");
			
			executeButton.setOnAction(e -> {
			try { 
				if (withdrawTextField.getText().isEmpty() || depositTextField.getText().isEmpty()) 
					{
					withdrawTextField.clear();
					depositTextField.clear();
					}
				else 
					{
						double withdraw = Double.parseDouble(withdrawTextField.getText()); 
						double deposit = Double.parseDouble(depositTextField.getText()); 
						s1.withdraw(withdraw);
						s1.deposit(deposit);
						balanceLabel.setText("Current Balance $" + s1.getBalance());
						balanceLabel.setText("Current Balance $" + s1.getBalance());
						depositTextField.clear();
						withdrawTextField.clear();
					}
			}
			
			catch(Exception a) 
			{
				depositTextField.clear();
				depositTextField.clear();
	
			}
		});


		layout3.getChildren().addAll(executeButton, balanceLabel);
		layout2.getChildren().addAll(depositTextField, withdrawTextField);
		layout1.getChildren().addAll(customerNameLabel, customerIDLabel, layout2, layout3);
		
		
		scene1 = new Scene(layout1, 400,400);	
		window.setTitle("Bank Application");
		window.setScene(scene1);
		window.show();
	}
}
