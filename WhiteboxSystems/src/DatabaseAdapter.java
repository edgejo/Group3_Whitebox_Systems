import java.util.ArrayList;

public interface DatabaseAdapter {
	public void addOrder(OrderDetails orderDetails);
	
	public ArrayList<OrderDetails> getExistingOrders();
}
