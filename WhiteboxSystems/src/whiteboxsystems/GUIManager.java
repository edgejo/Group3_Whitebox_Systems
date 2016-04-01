package whiteboxsystems;

import java.util.ArrayList;

import orderinfo.OrderDetails;

public class GUIManager {
	private DatabaseController databaseController;
	private ExistingOrdersWindow existingOrdersWindow;
	private NewOrderWindow newOrderWindow;
	
	public GUIManager(DatabaseController databaseController) {
		this.databaseController = databaseController;
		existingOrdersWindow = new ExistingOrdersWindow(this);
		displayExistingOrdersWindow();
	}
	
	public void displayExistingOrdersWindow(){
		ArrayList<OrderDetails> existingOrders = databaseController.getExistingOrders();
		existingOrdersWindow.displayExistingOrders(existingOrders);
	}
	
	public void displayNewOrderWindow(){
		newOrderWindow = new NewOrderWindow(this);
	}
	
	public void submitNewOrder(OrderDetails orderDetails){
		databaseController.createNewOrder(orderDetails);
		newOrderWindow.setVisible(false);
		newOrderWindow.dispose();
		displayExistingOrdersWindow();
	}
}
