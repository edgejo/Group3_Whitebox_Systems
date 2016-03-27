package whiteboxsystems;
import java.util.ArrayList;

import orderinfo.OrderDetails;

public interface DatabaseAdapter {
	public void addOrder(OrderDetails orderDetails);
	
	public ArrayList<OrderDetails> getExistingOrders();
}
