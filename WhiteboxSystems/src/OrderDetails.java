
import java.util.*;

public class OrderDetails {	
	
	private Integer buildID;
	private CustomerInfo customerInfo;
	private PaymentInfo paymentInfo;
	private Collection<ProductInfo> components;
	
	public OrderDetails(Integer buildID) {
		this.buildID = buildID;
		this.customerInfo = new CustomerInfo();
		this.paymentInfo = new PaymentInfo();
		this.components = new ArrayList<ProductInfo>();
	}
	
	public Integer getBuildID() {
		return buildID;
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
}
