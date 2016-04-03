package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import orderinfo.CustomerInfo;
import orderinfo.OrderDetails;
import orderinfo.PaymentInfo;
import orderinfo.ProductInfo;

public class OrderDetailsTest {

	OrderDetails orderDetails;

	@Before
    public void setUp() {
		this.orderDetails = generateOrderDetails();
    }
    
    private OrderDetails generateOrderDetails(){
    	Integer buildID = 1;
    	
     	// create CustomerInfo
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
		ProductInfo prodInfo1 = new ProductInfo(
				"Motherboard", "Asus", "It's not a fatherboard.",
				"ABC123XXX", "XXX321CBA", 11.1, 200.0, "3 years", "2030-11-01", "2016-03-03", 
				12345678, 987654321, 999999
				);
		
		ProductInfo prodInfo2 = new ProductInfo(
				"Fatherboard", "ASUS", "It's not a motherboard", 
				"235151", "5555", 20.22, 505.50, "test", "expiry", "today", 
				101, 102, 103
				);
		
		Collection<ProductInfo> components = new ArrayList<ProductInfo>();
		components.add(prodInfo1);
		components.add(prodInfo2);

		//Create order details
		OrderDetails od = new OrderDetails();
		od.setBuildID(buildID);
		od.setCustomerInfo(custInfo);
		od.setPaymentInfo(payInfo);
		od.setComponents(components);
		return od;
    }
    
    @Test
	public void testEquals() {
    	// Test 1: create an identical OrderDetails and check for equality
    	OrderDetails orderDetails1 = generateOrderDetails();
    	assertTrue(orderDetails.equals(orderDetails1));
    	
    	// Test 2: Change a value in CustomerInfo and test that equals() should fail
    	OrderDetails orderDetails2 = generateOrderDetails();
    	orderDetails2.getCustomerInfo().setName("incorrect");
    	assertFalse(orderDetails.equals(orderDetails2));
    	
    	// Test 3: Change a value in PaymentInfo and test that equals() should fail
    	OrderDetails orderDetails3 = generateOrderDetails();
    	orderDetails3.getPaymentInfo().setPaymentMethod("incorrect");
    	assertFalse(orderDetails.equals(orderDetails3));
    	
    	// Test 4: Add a value in Components and test that equals() should fail
    	OrderDetails orderDetails4 = generateOrderDetails();
    	ArrayList<ProductInfo> components4 = (ArrayList<ProductInfo>) orderDetails4.getComponents();
    	components4.add(new ProductInfo());
    	orderDetails4.setComponents(components4);
    	assertFalse(orderDetails.equals(orderDetails4));
    	
    	// Test 5: Change a value in Components and test that equals() should fail
    	OrderDetails orderDetails5 = generateOrderDetails();
    	ArrayList<ProductInfo> components5 = (ArrayList<ProductInfo>) orderDetails5.getComponents();
    	components5.get(0).setComponentType("incorrect");
    	assertFalse(orderDetails.equals(orderDetails5));
    	
    	// Test 6: Check with null parameters
    	OrderDetails orderDetails6 = generateOrderDetails();
    	orderDetails6.setBuildID(null);
    	orderDetails6.setCustomerInfo(null);
    	orderDetails6.setPaymentInfo(null);
    	orderDetails6.setComponents(null);
    	assertFalse(orderDetails.equals(orderDetails6));
    	
    	// TODO what other cases are there?
    	
    }

    

    
    
}
