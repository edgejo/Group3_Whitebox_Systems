package whiteboxsystems;
import java.util.*;
import orderinfo.*;
import whiteboxsystems.DatabaseAdapter;
import whiteboxsystems.GUIManager;
import whiteboxsystems.SQLAdapter;

public class DatabaseController {
	private GUIManager guiManager;
	private DatabaseAdapter databaseAdapter;
	
	public DatabaseController(){
		this.databaseAdapter = new SQLAdapter();
		this.guiManager = new GUIManager(this);
	}
	
	public void displayExistingOrders(){
		this.guiManager.displayExistingOrdersWindow();
	}
	
	public ArrayList<OrderDetails> getExistingOrders(){
		return this.databaseAdapter.getExistingOrders();
	}
	
	public void createNewOrder(OrderDetails orderDetails){
		databaseAdapter.addOrder(orderDetails);
	}
	
	public static void main(String[] args) {
		new DatabaseController();
	}
}
