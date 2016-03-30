package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import junit.framework.Assert;
import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;
import whiteboxsystems.DatabaseController;

public class DatabaseControllerTest {

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
		String buildID = "abc123";
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
