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
	
	@Test
	public void testCreateNewOrderAndGetExistingOrder_NormalInput() {
		DatabaseController databaseController = new DatabaseController();
		databaseController.activate();

		//*** start of testCreateNewOrder ***
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
		String productInfoDescription = "It's not a fatherboard.";
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
		databaseController.createNewOrder(od);
		
		//*** start of testGetExistingOrder ***
		ArrayList<OrderDetails> existingOrders = new ArrayList<OrderDetails>();
		existingOrders.addAll(databaseController.getExistingOrders());
		//TODO assert based on how output from getExistingOrders is expected
		//
		//	FILL
		//
		//
	}
	
	@Test
	public void testCreateNewOrderAndGetExistingOrder_BogusInput() {
		DatabaseController databaseController = new DatabaseController();
		databaseController.activate();

		//*** start of testCreateNewOrder ***
		//BuildId
		Integer buildID = 1231111111111111111;
		//CustomerInfo
		String customerInfoName = "John Doe Doe Doe Doe Doe Doe Bada Bo";
		String customerInfoEmail = "cust@email.com 123";
		String customerInfoPhoneNum = "6131234567123456789";
		String customerInfoAddress = "123 Bank St.";
		String customerInfoDeliveryDate = "12-2020-31";
		CustomerInfo custInfo = new CustomerInfo(
				customerInfoName,
				customerInfoEmail,
				customerInfoPhoneNum,
				customerInfoAddress,
				customerInfoDeliveryDate
				);
		//PaymentInfo
		String paymentInfoPaymentMethod = "Credit Debit and Cash";
		Double paymentInfoTotalValue = 5999999999999.9;
		String paymentInfoDeliveryConfirmationFile = "Placeholder file content.";
		PaymentInfo payInfo = new PaymentInfo(
				paymentInfoPaymentMethod,
				paymentInfoTotalValue,
				paymentInfoDeliveryConfirmationFile
				);
		//ProductInfo
		String productInfoComponentType = "Motherboard123";
		String productInfoManufacturer = "Asus123";
		String productInfoDescription = "It's not a fatherboard.102928@c.x/aw1'';]q[wexcmbvn/z.x,~";
		String productInfoModelNum = "ABC123XXXLALALALALALALALALALA";
		String productInfoSerialNum = "XXX321CBA";
		Double productInfoRebateValue = 11.1;
		Double productInfoPrice = 200.0;
		String productInfoWarrantyPeriod = "3 years or maybe not";
		String productInfoWarrantyExpiry = "2030-11-01";
		String productInfoInvoiceDate = "Mike";
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
		databaseController.createNewOrder(od);
		
		//*** start of testGetExistingOrder ***
		ArrayList<OrderDetails> existingOrders = new ArrayList<OrderDetails>();
		existingOrders.addAll(databaseController.getExistingOrders());
		//TODO assert based on how output from getExistingOrders is expected
		//
		//	FILL
		//
		//
	}

	//more granular tests (unneeded?)
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

//	@Test
//	public void testMain() {
//		fail("Not yet implemented");
//	}

}
