package whiteboxsystems;
import java.util.ArrayList;

import orderinfo.OrderDetails;

public class GUI {
	
	DatabaseController databaseController;
	
	public GUI(DatabaseController databaseController){
		this.databaseController = databaseController;
	}
	
	// on start and after submitting new order
	public void displayExistingOrders(ArrayList<OrderDetails> existingOrders){
		// TODO display existingOrders in swing
		// TODO create button "New Order" that calls displayNewOrderForm()
	}
	
	// on pressing "New Order" on displayExistingOrders view
	public void displayNewOrderForm(){
		// TODO display form with empty fields
		// TODO create button "Submit New Order" that calls submitNewOrderForm()
	}
	
	// on pressing "Submit New Order" button
	public void submitNewOrderForm(){
		// TODO populate orderDetails from fields in displayNewOrderForm
		OrderDetails orderDetails = new OrderDetails(-1);
		databaseController.createNewOrder(orderDetails);
	}
}
