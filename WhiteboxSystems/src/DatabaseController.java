import java.util.*;

public class DatabaseController {
	private GUI gui;
	private DatabaseAdapter databaseAdapter;
	
	public DatabaseController(){
		this.gui = new GUI(this);
		this.databaseAdapter = new SQLAdapter();
	}
	
	// TODO rename later; this method takes you back to the ExistingOrders page
	public void activate(){
		// TODO create database connection/instance
		ArrayList<OrderDetails> existingOrders = getExistingOrders();
		this.gui.displayExistingOrders(existingOrders);
	}
	
	public ArrayList<OrderDetails> getExistingOrders(){
		return new ArrayList<OrderDetails>();
	}
	
	public void createNewOrder(OrderDetails orderDetails){
		databaseAdapter.addOrder(orderDetails);
		activate();
	}
	
	public static void main(String[] args) {
		DatabaseController databaseController = new DatabaseController();
		databaseController.activate();
	}
}
