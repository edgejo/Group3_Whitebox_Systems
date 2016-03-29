package whiteboxsystems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Statement;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;

public class SQLAdapter implements DatabaseAdapter {
		
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/whiteboxsystems";
			String username = "root";
			String password = "123";
			Class.forName(driver); Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void addOrder(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		try {
			Connection conn = getConnection();
			CustomerInfo customerInfo = orderDetails.getCustomerInfo();
			PaymentInfo paymentInfo = orderDetails.getPaymentInfo();
			Collection<ProductInfo> productInfo = orderDetails.getComponents();
			
			//Update Table customer_info
			String query = "SELECT * FROM customer_info WHERE `Phone Number` = '" + customerInfo.getPhoneNum() + "'";
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (!rs.next() ) {
			    query = "INSERT INTO customer_info VALUES ('" + orderDetails.getBuildID() + "', '" + customerInfo.getName() + "', '" + customerInfo.getEmail() + "', '" + customerInfo.getPhoneNum() + "', '" + customerInfo.getAddress() + "', '" + customerInfo.getDeliveryDate() + "')";
			} else {
				query = "UPDATE customer_info SET `Build IDs` = '" + rs.getString("Build IDs") + "," + orderDetails.getBuildID() + "' WHERE `Phone Number` = '" + customerInfo.getPhoneNum() + "'";
			}
			System.out.println(query);
			
			st = conn.createStatement();
			st.executeUpdate(query);
			
			//Update Table payment_info
			query = "INSERT INTO payment_info VALUES ('" + paymentInfo.getPaymentMethod() + "', '" + paymentInfo.getTotalValue() + "', '" + paymentInfo.getDeliveryConfirmationFile() + "', '" + orderDetails.getBuildID() + "')";
			System.out.println(query);
			st = conn.createStatement();
			st.executeUpdate(query);
			
			//Update Table product_info
			ArrayList<ProductInfo> prodInfo = (ArrayList<ProductInfo>)productInfo;
			for (int i = 0; i < prodInfo.size(); i++) {
				query = "INSERT INTO product_info VALUES ('" + prodInfo.get(i).getComponentType() 
						+ "', '" + prodInfo.get(i).getManufacturer() 
						+ "', '" + prodInfo.get(i).getDescription() 
						+ "', '"  + prodInfo.get(i).getModelNum() 
						+ "', '"  + prodInfo.get(i).getSerialNum() 
						+ "', '"  + prodInfo.get(i).getRebateValue() 
						+ "', '"  + prodInfo.get(i).getPrice() 
						+ "', '"  + prodInfo.get(i).getWarrantyPeriod() 
						+ "', '" + prodInfo.get(i).getWarrantyExpiry() 
						+ "', '" + prodInfo.get(i).getInvoiceDate() 
						+ "', '" + prodInfo.get(i).getInvoiceNum() 
						+ "', '" + prodInfo.get(i).getSalesOrderNum() 
						+ "', '"   + prodInfo.get(i).getItemSKU() 
						+ "', '" +  orderDetails.getBuildID() + "')";
				st = conn.createStatement();
				st.executeUpdate(query);
				System.out.println(query);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 
	public ArrayList<OrderDetails> getExistingOrders() {
	// TODO Auto-generated method stub
		try {
			Connection conn = getConnection();
			ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
			String query = "SELECT * FROM customer_info";
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			//Get Customer Info
			while (rs.next()) {
				String buildIDs = rs.getString("Build IDs");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String phoneNumber = rs.getString("Phone Number");
				String address = rs.getString("Address");
				String deliveryDate = rs.getString("Delivery Date");
				System.out.println(buildIDs + " " + name + " " + email + " " + phoneNumber + " " + address + " " + deliveryDate);
				String bIDs[] = buildIDs.split(","); 
				for (int i = 0; i < bIDs.length; i++) {
					OrderDetails od = new OrderDetails(Integer.parseInt(bIDs[i]));
					CustomerInfo ci = new CustomerInfo(name, email, phoneNumber, address, deliveryDate);
					od.setCustomerInfo(ci);
					orderDetailsList.add(od);
				}
			}
		
			for (int i = 0; i < orderDetailsList.size(); i++) {
				query = "SELECT * FROM payment_info WHERE BuildID = \'" + orderDetailsList.get(i).getBuildID() + "\'";
				st = conn.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					String paymentMethod = rs.getString("Method");
					Double totalValue = rs.getDouble("Total Value");
					String deliveryConfirmation = rs.getString("Delivery Confirmation");
					PaymentInfo pi = new PaymentInfo(paymentMethod, totalValue, deliveryConfirmation);
					orderDetailsList.get(i).setPaymentInfo(pi);
					System.out.println(paymentMethod + " " + totalValue + " " + deliveryConfirmation);
				}
			}
		
			for (int i = 0; i < orderDetailsList.size(); i++) {
				query = "SELECT * FROM product_info WHERE BuildID = \'" + orderDetailsList.get(i).getBuildID() + "\'";
				st = conn.createStatement();
				rs = st.executeQuery(query);
				Collection<ProductInfo> collectionProdInfo = new ArrayList<ProductInfo>(); 
				while (rs.next()) {
					String componentType = rs.getString("Component Type");
					String manufacturer = rs.getString("Manufacturer");
					String productDescription = rs.getString("Product Description");
					String modelNumber = rs.getString("Model Number");
					String serialNumber = rs.getString("Serial Number");
					Double rebateValue = rs.getDouble("Rebate Value");
					Double price = rs.getDouble("Price");
					String warrantyPeriod = rs.getString("Warranty Period");
					String warrantyExpiry = rs.getString("Warranty Expiry");
					String invoiceDate = rs.getString("Invoice Date");
					Integer invoiceNumber = rs.getInt("Invoice Number");
					Integer salesOrderNumber = rs.getInt("Sales Order Number");
					Integer itemSKU = rs.getInt("Item SKU");
					ProductInfo prodInfo = new ProductInfo(componentType, manufacturer, productDescription, modelNumber, serialNumber, rebateValue, price, warrantyPeriod, warrantyExpiry, invoiceDate, invoiceNumber, salesOrderNumber, itemSKU);
					System.out.println(componentType + " " + manufacturer + " " + productDescription + " " + modelNumber + " " + serialNumber + " " + rebateValue + " " + price + " " + warrantyPeriod + " " + warrantyExpiry + " " + invoiceDate + " " + invoiceNumber + " " + salesOrderNumber + " " + itemSKU);
					collectionProdInfo.add(prodInfo);
				}
				orderDetailsList.get(i).setComponents(collectionProdInfo);
			}
		
			return orderDetailsList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
				
	}
	
}
