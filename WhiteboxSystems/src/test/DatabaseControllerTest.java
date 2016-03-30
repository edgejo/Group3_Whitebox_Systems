package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;
import whiteboxsystems.DatabaseController;

public class DatabaseControllerTest {

	@BeforeClass
	public static void deleteData(){
		
		ArrayList<String> tableNames = new ArrayList<String>(Arrays.asList(
				"customer_info", "payment_info", "product_info"));
		
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://whiteboxsystemsdb.cvr6heqg7wkw.us-west-2.rds.amazonaws.com:3306/whiteboxsystems";
			String username = "nfciotrestaurant";
			String password = "HussainIsTheBest";
			Class.forName(driver); 
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}
		
		for (String tableName : tableNames){
			Statement st;
			try {
				if (conn != null){
					st = conn.createStatement();
					st.executeUpdate("DELETE FROM " + tableName + ";");	
					System.out.println("Deleted table " + tableName);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	@Test
//	public void testDatabaseController() {
//		DatabaseController dbController = new DatabaseController();
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testActivate() {
//		DatabaseController dbController = new DatabaseController();
//		dbController.activate();
//		fail("Not yet implemented");
//	}

	@Test
	public void testCreateNewOrder() {
		DatabaseController databaseController = new DatabaseController();
		databaseController.activate();
		
		//BuildId
		Integer buildID = 123;
		//CustomerInfo
		String customerInfoName = "John Doe";
		String customerInfoEmail = "cust@email.com";
		String customerInfoPhoneNum = "6131234567";
		String customerInfoAddress = "123 Bank St.";
		String customerInfoDeliveryDate = "2020-12-31";
		CustomerInfo custInfo = new CustomerInfo(
				customerInfoName,
				customerInfoEmail,
				customerInfoPhoneNum,
				customerInfoAddress,
				customerInfoDeliveryDate
				);
		//PaymentInfo
		String paymentInfoPaymentMethod = "Credit";
		Double paymentInfoTotalValue = 599.9;
		String paymentInfoDeliveryConfirmationFile = "Placeholder file content.";
		PaymentInfo payInfo = new PaymentInfo(
				paymentInfoPaymentMethod,
				paymentInfoTotalValue,
				paymentInfoDeliveryConfirmationFile
				);
		//ProductInfo
		String productInfoComponentType = "Motherboard";
		String productInfoManufacturer = "Asus";
		// TODO revert back to "It's" and catch and fix apostrophe bug
		String productInfoDescription = "Its not a fatherboard.";
		String productInfoModelNum = "ABC123XXX";
		String productInfoSerialNum = "XXX321CBA";
		Double productInfoRebateValue = 11.1;
		Double productInfoPrice = 200.0;
		String productInfoWarrantyPeriod = "3 years";
		String productInfoWarrantyExpiry = "2030-11-01";
		String productInfoInvoiceDate = "2016-03-03";
		Integer productInfoInvoiceNum = 12345678;
		Integer productInfoSalesOrderNum = 987654321;
		Integer productInfoItemSKU = 999999;
		ProductInfo prodInfo = new ProductInfo(
				productInfoComponentType, 
				productInfoManufacturer, 
				productInfoDescription, 
				productInfoModelNum, 
				productInfoSerialNum, 
				productInfoRebateValue, 
				productInfoPrice, 
				productInfoWarrantyPeriod, 
				productInfoWarrantyExpiry, 
				productInfoInvoiceDate, 
				productInfoInvoiceNum, 
				productInfoSalesOrderNum, 
				productInfoItemSKU
				);
		Collection<ProductInfo> components = new ArrayList<ProductInfo>();
		components.add(prodInfo);

		//Create order details
		OrderDetails od = new OrderDetails(buildID);
		od.setCustomerInfo(custInfo);
		od.setPaymentInfo(payInfo);
		od.setComponents(components);
		
		try {
			databaseController.createNewOrder(od);
		} catch (Exception e){
			e.printStackTrace();
			fail("Exception occurred");
		}
		
		//TODO some sort of assert?
		
	}
	
	@Test
	public void testGetExistingOrders() {
		fail("Not yet implemented");
	}



//	@Test
//	public void testMain() {
//		fail("Not yet implemented");
//	}

}
