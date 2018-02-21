import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BankApplication extends Application implements EventHandler<ActionEvent>{
	
	Customer c1 = new Customer("John", 12345);
	SavingsAccount s1 = new SavingsAccount(c1, 150.00);
	Button b1;
	
	public static void main(String[] args) {
		launch(args);	
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bank Application");
		b1 = new Button("Execute");
		b1.setOnAction(e -> System.out.println());
		
		StackPane layout = new StackPane();
		layout.getChildren().add(b1);
		
		layout.getInputMethodRequests().getSelectedText();
		Scene scene = new Scene(layout, 300, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
