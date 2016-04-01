package orderinfo;

import java.util.*;

public class OrderDetails {	
	
	private Integer buildID;
	private CustomerInfo customerInfo;
	private PaymentInfo paymentInfo;
	private Collection<ProductInfo> components;
	
	public OrderDetails() {
		this.customerInfo = new CustomerInfo();
		this.paymentInfo = new PaymentInfo();
		this.components = new ArrayList<ProductInfo>();
	}
	
	public Integer getBuildID() {
		return buildID;
	}
	
	public void setBuildID(Integer buildID) {
		this.buildID = buildID;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public Collection<ProductInfo> getComponents() {
		return components;
	}

	public void setComponents(Collection<ProductInfo> components) {
		this.components = components;
	}
	
	@Override
	public boolean equals(Object o){
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof OrderDetails)) {
            return false;
        }
         
        OrderDetails orderDetails = (OrderDetails) o;
		
		return (this.getBuildID().equals(orderDetails.getBuildID())
				&& this.getCustomerInfo().equals(orderDetails.getCustomerInfo())
				&& this.getPaymentInfo().equals(orderDetails.getPaymentInfo())
				&& this.getComponents().equals(orderDetails.getComponents()));
	}
}
