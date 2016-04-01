package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import orderinfo.OrderDetails;

public class OrderDetailsTest {

	OrderDetails orderDetails;
	Integer buildID = 1;
	
    @Before
    public void setUp() {
		orderDetails = new OrderDetails();
    }

	@Test
	public void testGetBuildID() {
		assertTrue(orderDetails.getBuildID().equals(buildID));
	}

	@Test
	public void testGetCustomerInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCustomerInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaymentInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPaymentInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComponents() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetComponents() {
		fail("Not yet implemented");
	}

}
