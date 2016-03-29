package whiteboxsystems;
import java.util.*;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;

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
		OrderDetails ahmed = new OrderDetails(1234);
		CustomerInfo customerInfo1 = new CustomerInfo("Ahmed Omar", "ahmed@gmail.com", "6138545975", "1125 Colonel By Drive");
		ahmed.setCustomerInfo(customerInfo1);
		
		ArrayList<OrderDetails> existingOrders = new ArrayList<OrderDetails>();
		existingOrders.add(ahmed);
		return existingOrders;
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
