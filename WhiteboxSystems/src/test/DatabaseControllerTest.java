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
import org.omg.CORBA.LocalObject;

import com.sun.istack.internal.logging.Logger;
import com.sun.javafx.Logging;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;
import sun.util.logging.resources.logging;
import whiteboxsystems.DatabaseController;

public class DatabaseControllerTest {
	Logger log = Logger.getLogger(LocalObject.class);
	public static void deleteData(){
		Logger log = Logger.getLogger(LocalObject.class);
		log.info("Clearing all DB tables...");
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
		DatabaseControllerTest.deleteData(); //format remote db
		log.info("Starting testCreateNewOrderAndGetExistingOrder_NormalInput...");
		DatabaseController databaseController = new DatabaseController();

		//*** start of testCreateNewOrder (input)***
		//Creating BuildID:
		Integer buildID = 1;
		//Creating CustomerInfo:
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
		//Creating PaymentInfo:
		String paymentInfoPaymentMethod = "Credit";
		Double paymentInfoTotalValue = 599.9;
		String paymentInfoDeliveryConfirmationFile = "Placeholder file content.";
		PaymentInfo payInfo = new PaymentInfo(
				paymentInfoPaymentMethod,
				paymentInfoTotalValue,
				paymentInfoDeliveryConfirmationFile
				);
		//Creating ProductInfo:
		String productInfoComponentType = "Motherboard";
		String productInfoManufacturer = "Asus";
		//String productInfoDescription = "It's not a fatherboard."; //BUG: apostrophe-related
		String productInfoDescription = "Not a fatherboard.";
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
		//Create order details of all of the above
		OrderDetails od = new OrderDetails();
		od.setBuildID(buildID);
		od.setCustomerInfo(custInfo);
		od.setPaymentInfo(payInfo);
		od.setComponents(components);
		databaseController.createNewOrder(od);
		
		//*** start of testGetExistingOrder (output)***
		ArrayList<OrderDetails> existingOrders = new ArrayList<OrderDetails>();
		existingOrders.addAll(databaseController.getExistingOrders());
		for (OrderDetails actualOrderDetails: existingOrders){
        	Integer buildIDActual = actualOrderDetails.getBuildID();
        	CustomerInfo customerInfoActual = actualOrderDetails.getCustomerInfo();
        	PaymentInfo paymentInfoActual = actualOrderDetails.getPaymentInfo();
        	ArrayList<ProductInfo> componentsActual = (ArrayList<ProductInfo>) actualOrderDetails.getComponents();
        	
        	//Asserting BuildID:
        	assertEquals(buildID, buildIDActual);
        	//Asserting CustomerInfo:
        	assertEquals(customerInfoName, customerInfoActual.getName());
        	assertEquals(customerInfoEmail, customerInfoActual.getEmail());
        	assertEquals(customerInfoPhoneNum, customerInfoActual.getPhoneNum());
        	assertEquals(customerInfoAddress, customerInfoActual.getAddress());
        	assertEquals(customerInfoDeliveryDate, customerInfoActual.getDeliveryDate());
        	//Asserting PaymentInfo:
        	assertEquals(paymentInfoPaymentMethod, paymentInfoActual.getPaymentMethod());
        	assertEquals(paymentInfoTotalValue, paymentInfoActual.getTotalValue());
        	assertEquals(paymentInfoDeliveryConfirmationFile, paymentInfoActual.getDeliveryConfirmationFile());
        	//Asserting ProductInfo:
        	for (ProductInfo component: componentsActual) {
        		assertEquals(productInfoComponentType, component.getComponentType());
	        	assertEquals(productInfoManufacturer, component.getManufacturer());
	        	assertEquals(productInfoDescription, component.getDescription());
	        	assertEquals(productInfoModelNum, component.getModelNum());
	        	assertEquals(productInfoSerialNum, component.getSerialNum());
	        	assertEquals(productInfoRebateValue, component.getRebateValue());
	        	assertEquals(productInfoPrice, component.getPrice());
	        	assertEquals(productInfoWarrantyPeriod, component.getWarrantyPeriod());
	        	assertEquals(productInfoWarrantyExpiry, component.getWarrantyExpiry());
	        	assertEquals(productInfoInvoiceDate, component.getInvoiceDate());
	        	assertEquals(productInfoInvoiceNum, component.getInvoiceNum());
	        	assertEquals(productInfoSalesOrderNum, component.getSalesOrderNum());
	        	assertEquals(productInfoItemSKU, component.getItemSKU());
        	}
		}
		log.info("Ending testCreateNewOrderAndGetExistingOrder_NormalInput...");
	}
	
	@Test
	public void testCreateNewOrderAndGetExistingOrder_BogusInput() {
		DatabaseControllerTest.deleteData(); //format remote db
		log.info("Starting testCreateNewOrderAndGetExistingOrder_BogusInput...");
		DatabaseController databaseController = new DatabaseController();
		//*** start of testCreateNewOrder (input)***
		//Creating BuildID:
		Integer buildID = 123;
		//Creating CustomerInfo:
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
		//Creating PaymentInfo:
		//String paymentInfoPaymentMethod = "Credit Debit and Cash"; //BUG: String too long for this field
		String paymentInfoPaymentMethod = "No Money";
		Double paymentInfoTotalValue = 5999999999999.9;
		String paymentInfoDeliveryConfirmationFile = "Placeholder file content.";
		PaymentInfo payInfo = new PaymentInfo(
				paymentInfoPaymentMethod,
				paymentInfoTotalValue,
				paymentInfoDeliveryConfirmationFile
				);
		//Creating ProductInfo:
		String productInfoComponentType = "Motherboard123";
		String productInfoManufacturer = "Asus123";
		String productInfoDescription = "It''s not a fatherboard.102928@c.x/aw1'';]q[wexcmbvn/z.x,~";
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
		//Create order details of all of the above
		OrderDetails od = new OrderDetails();
		od.setBuildID(buildID); //BUG: Regardless of what you set buildID (here set to 123), it'll always be set to <last row number in table> (here set to 1 since table starts empty) 
		od.setCustomerInfo(custInfo);
		od.setPaymentInfo(payInfo);
		od.setComponents(components);
		databaseController.createNewOrder(od);
		
		//*** start of testGetExistingOrder (output)***
		ArrayList<OrderDetails> existingOrders = new ArrayList<OrderDetails>();
		existingOrders.addAll(databaseController.getExistingOrders());
		for (OrderDetails actualOrderDetails: existingOrders){
        	Integer buildIDActual = actualOrderDetails.getBuildID();
        	CustomerInfo customerInfoActual = actualOrderDetails.getCustomerInfo();
        	PaymentInfo paymentInfoActual = actualOrderDetails.getPaymentInfo();
        	ArrayList<ProductInfo> componentsActual = (ArrayList<ProductInfo>) actualOrderDetails.getComponents();
        	
        	//Asserting BuildID:
        	assertEquals(buildID, buildIDActual);
        	//Asserting CustomerInfo:
        	assertEquals(customerInfoName, customerInfoActual.getName());
        	assertEquals(customerInfoEmail, customerInfoActual.getEmail());
        	assertEquals(customerInfoPhoneNum, customerInfoActual.getPhoneNum());
        	assertEquals(customerInfoAddress, customerInfoActual.getAddress());
        	assertEquals(customerInfoDeliveryDate, customerInfoActual.getDeliveryDate());
        	//Asserting PaymentInfo:
        	assertEquals(paymentInfoPaymentMethod, paymentInfoActual.getPaymentMethod());
        	assertEquals(paymentInfoTotalValue, paymentInfoActual.getTotalValue());
        	assertEquals(paymentInfoDeliveryConfirmationFile, paymentInfoActual.getDeliveryConfirmationFile());
        	//Asserting ProductInfo:
        	for (ProductInfo component: componentsActual) {
        		assertEquals(productInfoComponentType, component.getComponentType());
	        	assertEquals(productInfoManufacturer, component.getManufacturer());
	        	assertEquals(productInfoDescription, component.getDescription());
	        	assertEquals(productInfoModelNum, component.getModelNum());
	        	assertEquals(productInfoSerialNum, component.getSerialNum());
	        	assertEquals(productInfoRebateValue, component.getRebateValue());
	        	assertEquals(productInfoPrice, component.getPrice());
	        	assertEquals(productInfoWarrantyPeriod, component.getWarrantyPeriod());
	        	assertEquals(productInfoWarrantyExpiry, component.getWarrantyExpiry());
	        	assertEquals(productInfoInvoiceDate, component.getInvoiceDate());
	        	assertEquals(productInfoInvoiceNum, component.getInvoiceNum());
	        	assertEquals(productInfoSalesOrderNum, component.getSalesOrderNum());
	        	assertEquals(productInfoItemSKU, component.getItemSKU());
        	}
		}
		log.info("Ending testCreateNewOrderAndGetExistingOrder_BogusInput...");
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
